package com.zhanghui.rommer.domain;

public class ActivityUser extends Id{
	private String channel;
	private String lastShowAdDate;
	private String country;
	private int count;
	
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getLastShowAdDate() {
		return lastShowAdDate;
	}
	public void setLastShowAdDate(String lastShowAdDate) {
		this.lastShowAdDate = lastShowAdDate;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
