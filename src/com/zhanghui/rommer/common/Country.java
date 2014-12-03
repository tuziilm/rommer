package com.zhanghui.rommer.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Country {
    public final static List<Country> countries = initCountries();
    public final static Map<String,Country> shortcut2CountryMap= initShortcut2CountryMap();
    public final static Map<String,Country> mcc2CountryMap= initMcc2CountryMap();

    private String shortcut;
    private String chineseName;
    private String mcc;

    private static Map<String,Country> initMcc2CountryMap() {
        Map<String, Country> map=new HashMap<>(countries.size());
        for(Country country : countries){
            map.put(country.getMcc(), country);
        }
        return map;
    }


    private static Map<String,Country> initShortcut2CountryMap() {
        Map<String, Country> map=new HashMap<>(countries.size());
        for(Country country : countries){
            map.put(country.getShortcut(), country);
        }
        return map;
    }


    private static List<Country> initCountries() {
        List<Country> _countries=new ArrayList<Country>(217);
        _countries.add(new Country("ae","431","������"));
        _countries.add(new Country("af","412","������"));
        _countries.add(new Country("ag","344","����ϺͰͲ���"));
        _countries.add(new Country("ai","365","������"));
        _countries.add(new Country("al","276","����������"));
        _countries.add(new Country("am","283","��������"));
        _countries.add(new Country("ao","631","������"));
        _countries.add(new Country("ar","722","����͢"));
        _countries.add(new Country("as","544","������Ħ��"));
        _countries.add(new Country("at","232","�µ���"));
        _countries.add(new Country("au","505","�Ĵ�����"));
        _countries.add(new Country("aw","363","��³��"));
        _countries.add(new Country("az","400","�����ݽ�"));
        _countries.add(new Country("ba","218","��˹���Ǻͺ�����ά��"));
        _countries.add(new Country("bb","342","�ͰͶ�˹"));
        _countries.add(new Country("bd","470","�ϼ���"));
        _countries.add(new Country("be","206","����ʱ"));
        _countries.add(new Country("bf","613","�����ɷ���"));
        _countries.add(new Country("bg","284","��������"));
        _countries.add(new Country("bh","426","����"));
        _countries.add(new Country("bi","642","��¡��"));
        _countries.add(new Country("bj","616","����"));
        _countries.add(new Country("bm","350","��Ľ��"));
        _countries.add(new Country("bn","528","����"));
        _countries.add(new Country("bo","736","����ά��"));
        _countries.add(new Country("br","724","����"));
        _countries.add(new Country("bs","364","�͹���"));
        _countries.add(new Country("bt","402","����"));
        _countries.add(new Country("bw","652","��������"));
        _countries.add(new Country("by","257","�׶���˹"));
        _countries.add(new Country("bz","702","������"));
        _countries.add(new Country("ca","302","���ô�"));
        _countries.add(new Country("cd","630","�չ�"));
        _countries.add(new Country("cf","623","�з�"));
        _countries.add(new Country("ch","228","��ʿ"));
        _countries.add(new Country("ci","612","���ص���"));
        _countries.add(new Country("ck","548","���Ⱥ��"));
        _countries.add(new Country("cl","730","����"));
        _countries.add(new Country("cm","624","����¡"));
        _countries.add(new Country("cn","461","�й�"));
        _countries.add(new Country("co","732","���ױ���"));
        _countries.add(new Country("cr","712","��˹�����"));
        _countries.add(new Country("cu","368","�Ű�"));
        _countries.add(new Country("cv","625","��ý�"));
        _countries.add(new Country("cy","280","����·˹"));
        _countries.add(new Country("cz","230","�ݿ�"));
        _countries.add(new Country("de","262","�¹�"));
        _countries.add(new Country("dj","638","������"));
        _countries.add(new Country("dk","238","����"));
        _countries.add(new Country("dm","366","�������"));
        _countries.add(new Country("do","370","�������"));
        _countries.add(new Country("dz","603","����������"));
        _countries.add(new Country("ec","740","��϶��"));
        _countries.add(new Country("ee","248","��ɳ����"));
        _countries.add(new Country("eg","602","����"));
        _countries.add(new Country("er","657","����������"));
        _countries.add(new Country("es","214","������"));
        _countries.add(new Country("et","636","���������"));
        _countries.add(new Country("fi","244","����"));
        _countries.add(new Country("fj","542","쳼�"));
        _countries.add(new Country("fm","550","�ܿ�������������"));
        _countries.add(new Country("fo","288","����Ⱥ��"));
        _countries.add(new Country("fr","208","����"));
        _countries.add(new Country("ga","628","����"));
        _countries.add(new Country("gb","234","Ӣ��"));
        _countries.add(new Country("gd","352","�����ɴ�"));
        _countries.add(new Country("ge","282","��³����"));
        _countries.add(new Country("gf","742","����������"));
        _countries.add(new Country("gh","620","����"));
        _countries.add(new Country("gi","266","ֱ������"));
        _countries.add(new Country("gl","290","������"));
        _countries.add(new Country("gm","607","�Ա���"));
        _countries.add(new Country("gn","611","������"));
        _countries.add(new Country("gp","340","�ϵ�����"));
        _countries.add(new Country("gq","627","���������"));
        _countries.add(new Country("gr","202","ϣ��"));
        _countries.add(new Country("gt","704","Σ������"));
        _countries.add(new Country("gu","535","�ص�"));
        _countries.add(new Country("gy","738","������"));
        _countries.add(new Country("hk","454","���"));
        _countries.add(new Country("hn","708","�鶼��˹"));
        _countries.add(new Country("hr","219","���޵���"));
        _countries.add(new Country("ht","372","����"));
        _countries.add(new Country("hu","216","������"));
        _countries.add(new Country("id","510","ӡ��������"));
        _countries.add(new Country("ie","272","������"));
        _countries.add(new Country("il","425","��ɫ��"));
        _countries.add(new Country("in","406","ӡ��"));
        _countries.add(new Country("iq","418","������"));
        _countries.add(new Country("ir","432","����"));
        _countries.add(new Country("is","274","����"));
        _countries.add(new Country("it","222","�����"));
        _countries.add(new Country("jm","338","�����"));
        _countries.add(new Country("jo","416","Լ��"));
        _countries.add(new Country("jp","440","�ձ�"));
        _countries.add(new Country("ke","639","������"));
        _countries.add(new Country("kg","437","������˹˹̹"));
        _countries.add(new Country("kh","456","����կ"));
        _countries.add(new Country("ki","545","�����˹"));
        _countries.add(new Country("km","654","��Ħ��"));
        _countries.add(new Country("kn","356","ʥ���ĺ���ά˹"));
        _countries.add(new Country("kp","467","����"));
        _countries.add(new Country("kr","450","����"));
        _countries.add(new Country("kw","419","������"));
        _countries.add(new Country("ky","346","����Ⱥ��"));
        _countries.add(new Country("kz","401","������˹̹"));
        _countries.add(new Country("la","457","����"));
        _countries.add(new Country("lb","415","�����"));
        _countries.add(new Country("lc","358","ʥ¬����"));
        _countries.add(new Country("li","295","��֧��ʿ��"));
        _countries.add(new Country("lk","413","˹������"));
        _countries.add(new Country("lr","618","��������"));
        _countries.add(new Country("ls","651","������"));
        _countries.add(new Country("lt","246","������"));
        _countries.add(new Country("lv","247","����ά��"));
        _countries.add(new Country("ly","606","������"));
        _countries.add(new Country("ma","604","Ħ���"));
        _countries.add(new Country("mc","212","Ħ�ɸ�"));
        _countries.add(new Country("md","259","Ħ������"));
        _countries.add(new Country("me","297","��ɽ"));
        _countries.add(new Country("mg","646","����˹��"));
        _countries.add(new Country("mh","551","���ܶ�Ⱥ��"));
        _countries.add(new Country("mk","294","¬ɭ��"));
        _countries.add(new Country("ml","610","����"));
        _countries.add(new Country("mm","414","���"));
        _countries.add(new Country("mn","428","�ɹ�"));
        _countries.add(new Country("mo","455","����"));
        _countries.add(new Country("mp","534","����������Ⱥ��"));
        _countries.add(new Country("mq","340","�������"));
        _countries.add(new Country("mr","609","ë��������"));
        _countries.add(new Country("ms","354","�������ص�"));
        _countries.add(new Country("mt","278","�����"));
        _countries.add(new Country("mu","617","ë����˹"));
        _countries.add(new Country("mv","472","�������"));
        _countries.add(new Country("mw","650","����ά"));
        _countries.add(new Country("mx","334","ī����"));
        _countries.add(new Country("my","502","��������"));
        _countries.add(new Country("mz","643","Īɣ�ȿ�"));
        _countries.add(new Country("na","649","���ױ���"));
        _countries.add(new Country("nc","546","�¿��������"));
        _countries.add(new Country("ne","614","���ն�"));
        _countries.add(new Country("ng","621","��������"));
        _countries.add(new Country("ni","710","�������"));
        _countries.add(new Country("nl","204","����"));
        _countries.add(new Country("no","242","Ų��"));
        _countries.add(new Country("np","429","�Ჴ��"));
        _countries.add(new Country("nr","536","�³"));
        _countries.add(new Country("nu","555","Ŧ��"));
        _countries.add(new Country("nz","530","������"));
        _countries.add(new Country("om","422","����"));
        _countries.add(new Country("pa","714","������"));
        _countries.add(new Country("pe","716","��³"));
        _countries.add(new Country("pf","547","��������������"));
        _countries.add(new Country("pg","537","�Ͳ����¼�����"));
        _countries.add(new Country("ph","515","���ɱ�"));
        _countries.add(new Country("pk","410","�ͻ�˹̹"));
        _countries.add(new Country("pl","260","����"));
        _countries.add(new Country("pm","308","ʥƤ�������ܿ�¡"));
        _countries.add(new Country("pr","330","�������"));
        _countries.add(new Country("ps","425","����˹̹"));
        _countries.add(new Country("pt","268","������"));
        _countries.add(new Country("pw","552","����"));
        _countries.add(new Country("py","744","������"));
        _countries.add(new Country("qa","427","������"));
        _countries.add(new Country("re","647","������"));
        _countries.add(new Country("ro","226","��������"));
        _countries.add(new Country("rs","220","����ά��"));
        _countries.add(new Country("ru","250","����˹"));
        _countries.add(new Country("rw","635","¬����"));
        _countries.add(new Country("sa","420","ɳ�ذ�����"));
        _countries.add(new Country("sb","540","������Ⱥ��"));
        _countries.add(new Country("sc","633","�����"));
        _countries.add(new Country("sd","634","�յ�"));
        _countries.add(new Country("se","240","���"));
        _countries.add(new Country("sg","525","�¼���"));
        _countries.add(new Country("si","293","˹��������"));
        _countries.add(new Country("sk","231","˹�工��"));
        _countries.add(new Country("sl","619","��������"));
        _countries.add(new Country("sm","292","ʥ����ŵ"));
        _countries.add(new Country("sn","608","���ڼӶ�"));
        _countries.add(new Country("so","637","������"));
        _countries.add(new Country("sr","746","������"));
        _countries.add(new Country("st","626","ʥ��������������"));
        _countries.add(new Country("sv","706","�����߶�"));
        _countries.add(new Country("sy","417","������"));
        _countries.add(new Country("sz","653","˹��ʿ��"));
        _countries.add(new Country("tc","376","�ؿ�˹�Ϳ���˹Ⱥ��"));
        _countries.add(new Country("td","622","է��"));
        _countries.add(new Country("tg","615","���"));
        _countries.add(new Country("th","520","̩��"));
        _countries.add(new Country("tj","436","������˹̹"));
        _countries.add(new Country("tl","514","������"));
        _countries.add(new Country("tm","438","������˹̹"));
        _countries.add(new Country("tn","605","ͻ��˹"));
        _countries.add(new Country("to","539","����"));
        _countries.add(new Country("tr","286","������"));
        _countries.add(new Country("tt","374","�������Ͷ�͸�"));
        _countries.add(new Country("tw","466","̨��"));
        _countries.add(new Country("tz","640","̹ɣ����"));
        _countries.add(new Country("ua","255","�ڿ���"));
        _countries.add(new Country("ug","641","�ڸɴ�"));
        _countries.add(new Country("us","316","����"));
        _countries.add(new Country("uy","748","������"));
        _countries.add(new Country("uz","434","���ȱ��˹̹"));
        _countries.add(new Country("va","225","��ٸ�"));
        _countries.add(new Country("vc","360","ʥ��ɭ�غ͸����ɶ�˹"));
        _countries.add(new Country("ve","734","ί������"));
        _countries.add(new Country("vg","348","Ӣ��ά����Ⱥ��"));
        _countries.add(new Country("vi","332","����ά����Ⱥ��"));
        _countries.add(new Country("vn","452","Խ��"));
        _countries.add(new Country("vu","541","��Ŭ��ͼ"));
        _countries.add(new Country("wf","543","����˹�͸�ͼ��"));
        _countries.add(new Country("ws","549","��Ħ��"));
        _countries.add(new Country("ye","421","Ҳ��"));
        _countries.add(new Country("za","655","�Ϸ�"));
        _countries.add(new Country("zm","645","�ޱ���"));
        _countries.add(new Country("zw","648","��Ͳ�Τ"));
        return _countries;
    }


    public Country(String shortcut, String mcc, String chineseName) {
        this.shortcut = shortcut;
        this.chineseName = chineseName;
        this.mcc = mcc;
    }

    public String getShortcut() {
        return shortcut;
    }

    public void setShortcut(String shortcut) {
        this.shortcut = shortcut;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public String getMcc() {
        return mcc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }
}
