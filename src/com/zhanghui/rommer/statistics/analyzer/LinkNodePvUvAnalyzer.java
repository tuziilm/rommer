package com.zhanghui.rommer.statistics.analyzer;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Sets;
import com.zhanghui.rommer.common.LogModule;
import com.zhanghui.rommer.statistics.common.*;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class LinkNodePvUvAnalyzer implements Analyzer {
    public final static Set<String> NAME_SET= Sets.newHashSet(LogModule.UPDATE.name(), LogModule.FLOATING_AD_GET_APP_RULE.name(),
            LogModule.PUSH_STAT.name(),LogModule.GET_PUSH_DATA.name(), LogModule.HOME_PAGE.name(), LogModule.PUSH_REGISTER.name());
    private Date date;
    private Map<String, ChartPvUvData> pvUvDataMap = new HashMap<>();
    private NDay nDay;


    public LinkNodePvUvAnalyzer(Date date) {
        this.date = date;
        this.nDay = new NDay("LINK_NODE_DAY_1", date);
    }

    private static class NDay {
        public String[] logFiles;
        public String[] dayStrings;
        public String module;

        NDay(String module, Date date) {
            this.module = module;
            this.logFiles = Config.getPreNDaysLogFiles(1, date);
            this.dayStrings = Config.getPreNDaysStrings(1, date);
        }
    }

    public static class LineEntry extends com.zhanghui.rommer.statistics.common.LineEntry {
        public String country;
        public String from;
        public String linkNode;
        public String hash;
        public String uid;
        @Override
        public LineEntry load(String line) {
            super.load(line);
            if (!NAME_SET.contains(name) || entries.length < 7) {
                valid = false;
                return this;
            }
            country=entries[4];
            if(Strings.isNullOrEmpty(country)){
                country = "00";
            }
            uid=entries[6];
            if(Strings.isNullOrEmpty(uid)){
                uid="00";
            }
            hash=String.valueOf(Math.abs(Objects.hashCode(uid))%256);

            linkNode=ChartPvUvData.mappedLinkNode(name);
            from=entries[7];
            from=from.length()>10?from.substring(0,10).trim():from.trim();//兼容线上from参数的错误
            if(Strings.isNullOrEmpty(from)){
                from="0000";
            }
            return this;
        }

        public String[] toKeys(){
            return new String[]{linkNode + Config.SEP + country + Config.SEP + from,
                    "all" + Config.SEP + country + Config.SEP + from,
                    linkNode + Config.SEP + "all" + Config.SEP + from,
                    linkNode + Config.SEP + country + Config.SEP + "all",
                    "all" + Config.SEP + "all" + Config.SEP + from,
                    "all" + Config.SEP + country + Config.SEP + "all",
                    linkNode + Config.SEP + "all" + Config.SEP + "all",
                    "all" + Config.SEP + "all" + Config.SEP + "all"
            };
        }
    }
    public static class PreHandledLineEntry extends ValidLineEntry{
        public String linkNode;
        public String country;
        public String from;
        public String uid;

        public PreHandledLineEntry load(String line){
            Iterator<String> fields = Splitter.on(Config.SEP).split(line).iterator();
            linkNode = fields.next();
            country = fields.next();
            from = fields.next();
            uid = fields.next();
            valid = true;
            return this;
        }

        public String[] toKeys(){
            return new String[]{linkNode + Config.SEP + country + Config.SEP + from,
                    "all" + Config.SEP + country + Config.SEP + from,
                    linkNode + Config.SEP + "all" + Config.SEP + from,
                    linkNode + Config.SEP + country + Config.SEP + "all",
                    "all" + Config.SEP + "all" + Config.SEP + from,
                    "all" + Config.SEP + country + Config.SEP + "all",
                    linkNode + Config.SEP + "all" + Config.SEP + "all",
                    "all" + Config.SEP + "all" + Config.SEP + "all"
            };
        }

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
        }
    }

    public List<ChartPvUvData> analyze() throws Exception {
        System.out.print("pre processing...");
        preprocess();
        System.out.println("...done");
        System.out.print("processing...");
        process();
        System.out.println("...done");
        List<ChartPvUvData> pvUvDatas = new ArrayList<>(pvUvDataMap.size());
        for(Map.Entry<String, ChartPvUvData> entry : pvUvDataMap.entrySet()){
            pvUvDatas.add(entry.getValue());
        }
        return pvUvDatas;
    }

    private void process() throws IOException {
        File dir = new File(Config.DIR_LOG+"/pvuv/"+nDay.dayStrings[0]);
        if(dir.exists()) {
            File[] files = dir.listFiles();
            AbstractLogFileHandler handler = new AbstractLogFileHandler<PreHandledLineEntry>() {
                private Map<String, Set<String>> uvMap;

                @Override
                public PreHandledLineEntry loadLineEntry(String line) {
                    return new PreHandledLineEntry().load(line);
                }

                @Override
                public void preHandleSingleFile() {
                    uvMap = new HashMap<>();
                }

                @Override
                public void postHandleSingleFile() {
                    for(Map.Entry<String, Set<String>> entry : uvMap.entrySet()){
                        ChartPvUvData chartPvUvData = pvUvDataMap.get(entry.getKey());
                        chartPvUvData.setUv(chartPvUvData.getUv() + entry.getValue().size());
                    }
                }

                @Override
                public void handleLine(int fIdx, PreHandledLineEntry entry) {
                    if (entry.valid) {
                        String[] keys = entry.toKeys();
                        for(String key : keys) {
                            Set<String> ipSet = uvMap.get(key);
                            if (ipSet == null) {
                                ipSet = new HashSet<>();
                                uvMap.put(key, ipSet);
                            }
                            ipSet.add(entry.uid);
                        }
                    }
                }
            };
            handler.handleFile(files);
            FileUtils.deleteDirectory(dir);
        }
    }

    /**
     * 预处理
     * 1，按IP Hash切分文件
     * 2，统计PV
     */
    private void preprocess() throws IOException {
        //创建切分文件夹
        Path path=Paths.get(Config.DIR_LOG+"/pvuv/"+nDay.dayStrings[0]);
        FileUtils.deleteDirectory(path.toFile());
        Files.createDirectories(path);
        final Map<String, BufferedWriter> outFileMap=new HashMap<>();
        AbstractLogFileHandler handler = new AbstractLogFileHandler<LineEntry>(){
            public int count=0;

            @Override
            public void postHandleMultiFiles() {
                System.out.println("count:"+count);
                for(Map.Entry<String, BufferedWriter> entry : outFileMap.entrySet()){
                    try {
                        entry.getValue().close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.exit(1);
                    }
                }
            }

            @Override
            public LineEntry loadLineEntry(String line) {
                return new LineEntry().load(line);
            }

            @Override
            public void handleLine(int fIdx, LineEntry entry) {
                if(entry.valid){
                    BufferedWriter bw = outFileMap.get(entry.hash);
                    if(bw ==null){
                        try {
                            bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Config.DIR_LOG+"/pvuv/"+nDay.dayStrings[fIdx]+"/"+entry.hash+".log"),"UTF-8"));
                            outFileMap.put(entry.hash, bw);
                        } catch (IOException e) {
                            e.printStackTrace();
                            System.exit(1);
                        }
                    }
                    try {
                        String[] keys=entry.toKeys();
                        for(String key : keys) {
                            ChartPvUvData chartPvUvData = pvUvDataMap.get(key);
                            if (chartPvUvData == null) {
                                chartPvUvData = new ChartPvUvData("LINK_NODE_DAY_1", nDay.dayStrings[fIdx], key, 1);
                                pvUvDataMap.put(key, chartPvUvData);
                            } else {
                                chartPvUvData.setPv(chartPvUvData.getPv() + 1);
                            }
                        }
                        bw.write(entry.linkNode);
                        bw.write(Config.SEP);
                        bw.write(entry.country);
                        bw.write(Config.SEP);
                        bw.write(entry.from);
                        bw.write(Config.SEP);
                        bw.write(entry.uid);
                        bw.write("\n");

                        count++;
                        if(count%100000==0){
                            System.out.println("count:"+count);
                            bw.flush();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.exit(1);
                    }
                }
            }
        };
        handler.handleFile(nDay.logFiles);
    }
}
