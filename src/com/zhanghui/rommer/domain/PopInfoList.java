package com.zhanghui.rommer.domain;


public class PopInfoList  extends Id {

	private String channel;
	private String lastShowAdDate;
	private String country;
	private Integer count;
	
	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public void setLastShowAdDate(String lastShowAdDate) {
		this.lastShowAdDate = lastShowAdDate;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getLastShowAdDate() {
		return lastShowAdDate;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}
