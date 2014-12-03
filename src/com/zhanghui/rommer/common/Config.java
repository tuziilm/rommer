package com.zhanghui.rommer.common;

import com.google.common.collect.Sets;
import com.google.common.io.Resources;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

/**
 * 集中定义一些常量
 * @author <a href="pangkunyi@gmail.com">Calvin Pang</a>
 *
 */
public final class Config {
    private final static Random rand = new Random(System.currentTimeMillis());
	public final static Properties props=new Properties();
	static{
		try {
			props.load(Resources.getResource("config.properties").openStream());
		} catch (IOException e) {
			System.exit(1);
		}
	}
	/** 文件上传根路径*/
	public final static String UPLOAD_ROOT_DIR=props.getProperty("upload.root.dir");
    public final static String APK_DECODE_DIR=UPLOAD_ROOT_DIR+"/"+".apk";
	public final static String DOMAIN=props.getProperty("domain");
    public final static String HOST_URL="http://"+DOMAIN;
	public final static String APP_NAME=props.getProperty("app.name");
    public static String[] DOWNLOAD_URL=props.getProperty("download.url").split("\\s+");
    public final static Set<String> TEST_IDENTITIES= Sets.newHashSet("460019002606393","460028174372880","460028998577977");

    public final static String randomDownloadURL(){
        if (DOWNLOAD_URL==null || DOWNLOAD_URL.length<1){
            return HOST_URL;
        }
        return DOWNLOAD_URL[rand.nextInt(DOWNLOAD_URL.length)];
    }

    public final static String randomDownloadURL(String prefix, String path){
        if(path==null){
            return "";
        }
        return randomDownloadURL()+prefix+path;
    }
}
