package com.zhanghui.rommer.statistics;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zhanghui.rommer.common.DateUtils;
import com.zhanghui.rommer.domain.PopInfo;
import com.zhanghui.rommer.service.PopInfoService;
import com.zhanghui.rommer.statistics.common.DatabaseHelper;

public class TimerSchedule {
	public void excude(){
		try {
			System.out.println("find all popInfos......");
			List<PopInfo> popInfoList = DatabaseHelper.findAllPopInfo();
			System.out.println(popInfoList.size());
			//查询出前一天的所有记录
			System.out.println("prehandler..............");
			popInfoList = preHandler(popInfoList);
			System.out.println(popInfoList.size());
			//将前一天所有记录备份到备份表中,统计激活量
			System.out.println("dohandler.................");
			doHandler(popInfoList);
			//删除原始表的前一天记录
			System.out.println("delete popiNFOS ................");
//			postHandler(popInfoList);
			System.out.println("success..................");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<PopInfo> preHandler(List<PopInfo> popInfoList){
		String yesterday = DateUtils.yesterdayString(DateUtils.SIMPLE_DATE_PATTERN2);
		Boolean flag = false;
		List<PopInfo> removeList = new ArrayList<PopInfo>();
		for(PopInfo p : popInfoList){
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
	public void doHandler(List<PopInfo> popInfoList){
		try {
			//备份到备份表中
			DatabaseHelper.persistToDatabase(popInfoList);
			DatabaseHelper.persistToDatabase2(popInfoList);
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
		TimerSchedule t = new TimerSchedule();
		t.excude();
	}
}
