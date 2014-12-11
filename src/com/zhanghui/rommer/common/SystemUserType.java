package com.zhanghui.rommer.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ϵͳ�û�����
 * @author <a href="pangkunyi@gmail.com">Calvin Pang</a>
 *
 */
public enum SystemUserType {
	/** ϵͳ����Ա*/
	ADMIN(0,"ϵͳ����Ա"),
	/** ��ͨ��Ӫ��Ա*/
	OPERATOR(1,"ҵ��Ա","/clerk","/sysuser/info_modify","/sysuser/index","/sysuser/info_save","/popInfo","/activityUser"),
	/** ������*/
	PROXY(2,"������","/proxy","/sysuser/info_modify","/sysuser/index","/sysuser/info_save","/popInfo","/activityUser"),
	/** �ͻ� */
	CLIENT(3,"�ͻ�","/client","/sysuser/info_modify","/sysuser/index","/sysuser/info_save","/popInfo","/activityUser"),
	/** δʶ��*/
	UNKNOWN(-1,"δ֪");
	private int id;
	private String name;
	private List<String> resources;
	SystemUserType(int id, String name, String ...resources){
		this.id=id;
		this.name=name;
		if(resources==null){
			this.resources=Collections.emptyList();
		}else{
			this.resources=new ArrayList<String>(resources.length);
			for(String resource : resources){
				this.resources.add(resource);
			}
		}
	}
	
	public int getId() {
		return id;
	}
	
	public List<String> getResources() {
		return resources;
	}
	public String getName() {
		return name;
	}
	public static SystemUserType valueOf(Byte type){
		if(type==null)
			return UNKNOWN;
		if(type==0)
			return ADMIN;
		if(type==1)
			return OPERATOR;
		if(type==2)
			return PROXY;
		if(type==3)
			return CLIENT;
		return UNKNOWN;
	}
}
