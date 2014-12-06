package com.zhanghui.rommer.persistence;

import com.zhanghui.rommer.common.Paginator;
import com.zhanghui.rommer.domain.PopInfo;

/**
 * ibatis操作统计表的Mapper接口
 * 
 */
public interface PopInfoMapper extends BaseMapper<PopInfo> {
	int countAll(Paginator page);
}