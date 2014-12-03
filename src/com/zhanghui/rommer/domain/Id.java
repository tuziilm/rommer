package com.zhanghui.rommer.domain;

import com.zhanghui.rommer.common.SqlFunc;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

public abstract class Id {
	/** ID*/
    protected Integer id;
    /** ����ʱ��*/
    protected Date gmtCreate;
    /** �޸�ʱ��*/
    protected Date gmtModified;

    public SqlFunc getFn(){
        return SqlFunc.get();
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
