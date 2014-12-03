package com.zhanghui.rommer.common;

import java.util.UUID;

/**
 * Redis Keys
 * @author <a href="mailto:pangkunyi@gmail.com">Calvin Pang</a>
 */
public final class RedisKeys {
    /** ���ڼ�¼�û��ֻ�����MT��Ϣ������, ���Դ˿��Լ������Ҫ���͵�MT��Ϣ*/
    public final static String TERMINAL_PRODUCT_mt_RECORD_NUM_HkEY=Config.APP_NAME+":terminal:productMT:recordNum";
    /** ���ڼ�¼��Ĭ��װ��Ӧ�ð�װ�б�, ֵ�磺2,3,4*/
    public final static String SILENT_INSTALL_SUCCESS_HKEY=Config.APP_NAME+":slient_install:success:appIds";
    /** ���ڼ�¼��Ĭ��װ���͵�Ӧ��ID*/
    public final static String SILENT_INSTALL_RECOMMAND_APPID_HKEY=Config.APP_NAME+":slient_install:recommand:appId";

    /**
     * ���ڸ������ݷ����version key
     * @param clz
     * @param module
     * @return
     */
    public static String moduleServiceVersionKey(Class clz, String module){
        return Config.APP_NAME+":"+clz.getName()+":"+module+":version";
    }


    public static String uploadKey(String id){
        return String.format("%s:upload:progress:%s", Config.APP_NAME, id);
    }

    public static String otaProgressKey(){
        return String.format("%s:ota:project_package:progress:%s", Config.APP_NAME, UUID.randomUUID().toString());
    }

    public static String silentInstallForbiddenKey(String identity){
        return String.format("%s:slient_install:forbidden:%s", Config.APP_NAME, identity);
    }

}
