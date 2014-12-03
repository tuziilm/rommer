package com.zhanghui.rommer.statistics;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import com.zhanghui.rommer.common.DateUtils;
import com.zhanghui.rommer.domain.PopInfo;
import com.zhanghui.rommer.service.PopInfoService;
import com.zhanghui.rommer.statistics.common.DatabaseHelper;

public class TimerSchedule {
	@Resource
	private PopInfoService popInfoService;
	public void excude(){
		List<PopInfo> popInfoList = popInfoService.listAll();
		//��ѯ��ǰһ������м�¼
		popInfoList = preHandler(popInfoList);
		//��ǰһ�����м�¼���ݵ����ݱ���,ͳ�Ƽ�����
		doHandler(popInfoList);
	}
	public List<PopInfo> preHandler(List<PopInfo> popInfoList){
		String yesterday = DateUtils.yesterdayString(DateUtils.SIMPLE_DATE_PATTERN2);
		Boolean flag = false;
		for(PopInfo p : popInfoList){
			String[] onLineTime = p.getOnLineTime().split(",");
			for(String str :onLineTime){
				if(str.equals(yesterday)){
					flag = true;
					break;
				}
			}
			if(!flag){
				popInfoList.remove(p);
			}
		}
		return popInfoList;
	}
	public void doHandler(List<PopInfo> popInfoList){
		try {
			//���ݵ����ݱ���
			DatabaseHelper.persistToDatabase(popInfoList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
