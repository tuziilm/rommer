package com.zhanghui.rommer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhanghui.rommer.common.Paginator;
import com.zhanghui.rommer.domain.ActivityUser;
import com.zhanghui.rommer.persistence.ActivityUserMapper;

@Service
public class ActivityUserService extends SimpleCacheSupportService<ActivityUser> {
	private ActivityUserMapper activityUserMapper;
	@Autowired
	public void setLinkMapper(ActivityUserMapper activityUserMapper) {
		this.mapper = activityUserMapper;
		this.activityUserMapper=activityUserMapper;
	}
	public int countAll(Paginator page){
		return activityUserMapper.countAll(page);
	}
}
