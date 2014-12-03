package com.zhanghui.rommer.domain;

public class SendPopInfo extends Id {

	private String uuid;
	
	private String countInstall;

	private String clickRate;
	
	private String isShowAd;
	
	private String tableName;
	
	private String showAdDay;
	
	private String isControlShow;
	
	private String clickHour;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getCountInstall() {
		return countInstall;
	}

	public void setCountInstall(String countInstall) {
		this.countInstall = countInstall;
	}

	public String getClickRate() {
		return clickRate;
	}

	public void setClickRate(String clickRate) {
		this.clickRate = clickRate;
	}

	public String getIsShowAd() {
		return isShowAd;
	}

	public void setIsShowAd(String isShowAd) {
		this.isShowAd = isShowAd;
	}

	public String getShowAdDay() {
		return showAdDay;
	}

	public void setShowAdDay(String showAdDay) {
		this.showAdDay = showAdDay;
	}

	public String getIsControlShow() {
		return isControlShow;
	}

	public void setIsControlShow(String isControlShow) {
		this.isControlShow = isControlShow;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getClickHour() {
		return clickHour;
	}

	public void setClickHour(String clickHour) {
		this.clickHour = clickHour;
	}
}
