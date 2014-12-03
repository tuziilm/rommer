package com.zhanghui.rommer.common;


/**
 * ��־ͳ��ģ��
 * @author <a href="pangkunyi@gmail.com">Calvin Pang</a>
 *
 */
public enum LogModule {
    UPDATE("Ӧ�ø���ͳ��","get/update"),
    FLOATING_AD_GET_APP_RULE("�������ͳ��", "get/get_ad"),
    PUSH_STAT("Pushͳ��", "callback/stat"),
    GET_PUSH_DATA("Push��������", "get/get_push_data"),
    PUSH_REGISTER("Push�û���Ϣ", "user/register"),
    HOME_PAGE("�������ҳ", "get/get_home_page");

	private String title;
    private String link;

	private LogModule(String title,String link) {
		this.title = title;
        this.link = link;
	}

    public String getLink() {
        return link;
    }

    public String getTitle() {
		return title;
	}
}
