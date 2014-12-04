package com.zhanghui.rommer.statistics;

import java.util.ArrayList;
import java.util.List;

import com.zhanghui.rommer.common.DateUtils;
import com.zhanghui.rommer.domain.PopInfo;
import com.zhanghui.rommer.statistics.common.DatabaseHelper;

public class TimerSchedule {
	public void excute(){
		try {
			List<PopInfo> popInfoList = DatabaseHelper.findAllPopInfo();
			System.out.println(popInfoList.size());
			//��ѯ��ǰһ������м�¼
			popInfoList = preHandler(popInfoList);
			//��ǰһ�����м�¼���ݵ����ݱ���,ͳ�Ƽ�����
			doHandler(popInfoList);
			//ɾ��ԭʼ���ǰһ���¼
			postHandler(popInfoList);
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
			//���ݵ����ݱ���
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
		t.excute();
	}
}
