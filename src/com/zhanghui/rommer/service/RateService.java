package com.zhanghui.rommer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhanghui.rommer.domain.Rate;
import com.zhanghui.rommer.persistence.RateMapper;

@Service
public class RateService extends SimpleCacheSupportService<Rate> {
	private RateMapper rateMapper;
	@Autowired
	public void setLinkMapper(RateMapper rateMapper) {
		this.mapper = rateMapper;
		this.rateMapper=rateMapper;
	}
}
