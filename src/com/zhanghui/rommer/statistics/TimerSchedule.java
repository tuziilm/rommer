package com.zhanghui.rommer.statistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zhanghui.rommer.common.DateUtils;
import com.zhanghui.rommer.domain.ActivityUser;
import com.zhanghui.rommer.domain.PopInfo;
import com.zhanghui.rommer.statistics.common.DatabaseHelper;

public class TimerSchedule {
	public void excute(){
		try {
			List<PopInfo> popInfoList = DatabaseHelper.findAllPopInfo();
			System.out.println(popInfoList.size());
			//查询出前一天的所有记录
			popInfoList = preHandler(popInfoList);
			System.out.println(popInfoList.size()+"after do handler");
			//将前一天所有记录备份到备份表中
			bakPopInfo(popInfoList);
			//统计激活量
			countActivityUser();
			//删除原始表的前一天记录
//			postHandler(popInfoList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<PopInfo> preHandler(List<PopInfo> popInfoList){
		String yesterday = DateUtils.yesterdayString(DateUtils.SIMPLE_DATE_PATTERN2);
		List<PopInfo> removeList = new ArrayList<PopInfo>();
		for(PopInfo p : popInfoList){
			Boolean flag = false;
			if(p.getOnLineTime()!=null){
				String[] onLineTime = p.getOnLineTime().split(",");
				for(String str :onLineTime){
					if(str.equals(yesterday)){
						flag = true;
					}
				}
			}
			if(!flag){
				removeList.add(p);
			}
		}
		popInfoList.removeAll(removeList);
		return popInfoList;
	}
	public void bakPopInfo(List<PopInfo> popInfoList){
		try {
			//备份到备份表中
			DatabaseHelper.persistToDatabase(popInfoList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void countActivityUser(){
		try {
			String yesterday = DateUtils.yesterdayString(DateUtils.SIMPLE_DATE_PATTERN2);
			//统计备份表中前一天激活量的数据
			List<ActivityUser> activityUsersList = DatabaseHelper.countFromBak(yesterday);
			
			Map<String, Integer> map = new HashMap<String,Integer>();
			for(ActivityUser a : activityUsersList){
				if(map.containsKey(a.getChannel())){
					map.put(a.getChannel(),(map.get(a.getChannel())+a.getCount()));
				}else{
					map.put(a.getChannel(), a.getCount());
				}
			}
			DatabaseHelper.saveActivityUser(activityUsersList,map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void postHandler(List<PopInfo> popInfoList){
		try {
			DatabaseHelper.deletePopInfo(popInfoList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
			TimerSchedule ts = new TimerSchedule();
			ts.excute();
	}
}
