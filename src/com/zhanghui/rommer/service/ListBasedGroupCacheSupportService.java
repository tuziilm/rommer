package com.zhanghui.rommer.service;

import com.zhanghui.rommer.common.Tuple;
import com.zhanghui.rommer.domain.Id;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * ע�⣺**�����ݱ��ܼ̳д˽ӿ�**�����Ӹ��²���ʱ��Ӧ�ü���resetCache(),���򻺴������Ч
 * @author <a href="pangkunyi@gmail.com">Calvin Pang</a>
 *
 * @param <T>
 */
public abstract class ListBasedGroupCacheSupportService<T extends Id> extends RedisSupportService<T> {
	protected final AtomicReference<Map<String,List<T>>> cache= new AtomicReference<Map<String,List<T>>>();

	public ListBasedGroupCacheSupportService() {
		super("groupKeyValue");
	}


	public List<T> getCache(String groupKey){
		Map<String,List<T>> expect= cache.get();
		Tuple<Boolean, Long> nldResult = needLoadData();
		if(expect==null || nldResult.first){
			Collection<T> list = listForCache();
			Map<String,List<T>> update=new HashMap<String, List<T>>(cacheGroupKeys().length);
			for(String cgk: cacheGroupKeys()){
				update.put(cgk, new ArrayList<T>());
			}
			for(T t: list){
				updateCacheList(update, t);
			}
			cache.compareAndSet(expect, update);
			version=nldResult.second;
			return update.get(groupKey);
		}
		return expect.get(groupKey);
	}
	
	public abstract String[] cacheGroupKeys();
	
	public abstract void updateCacheList(Map<String, List<T>> update, T t);
	
	protected Collection<T> listForCache(){
		return  listAll();
	}
}
