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
public abstract class ObjectBasedGroupCacheSupportService<T extends Id> extends RedisSupportService<T> {
	protected final AtomicReference<Map<String,Object>> cache= new AtomicReference<Map<String,Object>>();

	public ObjectBasedGroupCacheSupportService() {
		super("groupKeyValue");
	}


	public Object getCache(String groupKey){
		Map<String,Object> expect= cache.get();
		Tuple<Boolean, Long> nldResult = needLoadData();
		if(expect==null || nldResult.first){
			Collection<T> list = listForCache();
			Map<String,Object> update=new HashMap<String, Object>(cacheGroupKeys().length);
			for(String cgk: cacheGroupKeys()){
				update.put(cgk, newObject(cgk));
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

    public abstract Object newObject(String cacheGroupKey);

	public abstract void updateCacheList(Map<String, Object> update, T t);
	
	protected Collection<T> listForCache(){
		return  listAll();
	}
}
