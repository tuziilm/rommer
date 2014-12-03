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
		//查询出前一天的所有记录
		popInfoList = preHandler(popInfoList);
		//将前一天所有记录备份到备份表中,统计激活量
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
			//备份到备份表中
			DatabaseHelper.persistToDatabase(popInfoList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
