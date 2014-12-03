package com.zhanghui.rommer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhanghui.rommer.common.Paginator;
import com.zhanghui.rommer.domain.PopInfo;
import com.zhanghui.rommer.persistence.PopInfoMapper;

@Service
public class PopInfoService extends SimpleCacheSupportService<PopInfo> {
	private PopInfoMapper popInfoMapper;
	@Autowired
	public void setLinkMapper(PopInfoMapper popInfoMapper) {
		this.mapper = popInfoMapper;
		this.popInfoMapper=popInfoMapper;
	}
	public int countAll(Paginator page){
		return popInfoMapper.countAll(page);
	}
}
