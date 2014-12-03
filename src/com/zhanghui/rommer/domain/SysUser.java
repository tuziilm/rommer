package com.zhanghui.rommer.domain;

import com.zhanghui.rommer.common.SystemUserType;


/**
 * ϵͳ�û���
 * @author <a href="pangkunyi@gmail.com">Calvin Pang</a>
 *
 */
public class SysUser  extends RemarkId {
    /** �˺�*/
    private String username;
    /** ����*/
    private String passwd;
    /** ϵͳ�û�����,0:ϵͳ����Ա,1:ҵ��Ա, 2:������, 3���ͻ�*/
    private Byte sysUserType;
    /** ״̬,1:����,0:�쳣*/
    private Byte status;
    /** Ȩ��ֵ�б�,���磺1|2|3*/
    private String privilege;
    private String channel;

    public SystemUserType getSystemUserType(){
    	return SystemUserType.valueOf(sysUserType);
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    public Byte getSysUserType() {
        return sysUserType;
    }

    public void setSysUserType(Byte sysUserType) {
        this.sysUserType = sysUserType;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege == null ? null : privilege.trim();
    }

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}
    
}