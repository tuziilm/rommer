package com.zhanghui.rommer.common;


/**
 * 日志统计模块
 * @author <a href="pangkunyi@gmail.com">Calvin Pang</a>
 *
 */
public enum LogModule {
    UPDATE("应用更新统计","get/update"),
    FLOATING_AD_GET_APP_RULE("悬浮广告统计", "get/get_ad"),
    PUSH_STAT("Push统计", "callback/stat"),
    GET_PUSH_DATA("Push任务数据", "get/get_push_data"),
    PUSH_REGISTER("Push用户信息", "user/register"),
    HOME_PAGE("浏览器主页", "get/get_home_page");

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
