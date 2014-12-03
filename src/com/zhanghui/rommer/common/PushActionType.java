package com.zhanghui.rommer.common;

public class PushActionType {
    public final static int PUSH_2_NOTIFY_BAR_SUCCESS=10001; //表示广告已成功推送到手机的通知栏上
    public final static int CLICK_FROM_NOTIFY_BAR=10002; //表示用户点击了通知栏上的这个广告
    public final static int CLICK_DOWNLOAD_AT_APP_DETAIL=10003; //表示用户点击了应用简介窗口里的 下载 按钮
    public final static int CLICK_INSTALL_AT_APP_DETAIL=10004; //表示用户点击了应用简介窗口里的 安装 按钮
    public final static int APP_LIST_CLICK_ONE_APP=10005; //表示用户点击了应用列表窗口里的某一个应用
}
