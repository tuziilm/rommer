package com.zhanghui.rommer.persistence;

import com.zhanghui.rommer.common.Paginator;
import com.zhanghui.rommer.domain.PopInfo;

/**
 * ibatis����ͳ�Ʊ��Mapper�ӿ�
 * 
 */
public interface PopInfoMapper extends BaseMapper<PopInfo> {
	int countAll(Paginator page);
}