package com.zhanghui.rommer.persistence;

import java.util.List;

import com.zhanghui.rommer.common.Paginator;
import com.zhanghui.rommer.domain.PopInfo;
import com.zhanghui.rommer.domain.PopInfoList;

/**
 * ibatis操作统计表的Mapper接口
 * 
 * @author <a href="xuzhenqinandy@gmail.com">Calvin Pang</a>
 *
 */
public interface PopInfoMapper extends BaseMapper<PopInfo> {
	int countAll(Paginator page);
}