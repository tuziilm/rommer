package com.zhanghui.rommer.persistence;

import com.zhanghui.rommer.common.Paginator;
import com.zhanghui.rommer.domain.ActivityUser;

/**
 * ibatis�������������Mapper�ӿ�
 */
public interface ActivityUserMapper extends BaseMapper<ActivityUser> {
	int countAll(Paginator page);
}