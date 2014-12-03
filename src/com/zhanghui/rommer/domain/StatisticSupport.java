package com.zhanghui.rommer.domain;

/**
 * ͳ����չ
 * @author <a href="pangkunyi@gmail.com">Calvin Pang</a>
 * 
 */
public class StatisticSupport extends Id{
	public enum Type{
		/**����*/
		DOWNLOAD,
		/**��װ*/
		INSTALL
	}
	// ͳ����չ
	/** �Ƿ�Ҫͳ�������� */
	private boolean needCountDownload;
	/** �Ƿ�Ҫͳ�ư�װ�� */
	private boolean needCountInstall;

	public void setNeedCountInstall(boolean needCountInstall) {
		this.needCountInstall = needCountInstall;
	}

	public boolean isNeedCountInstall() {
		return needCountInstall;
	}

	public void setNeedCountDownload(boolean needCountDownload) {
		this.needCountDownload = needCountDownload;
	}

	public boolean isNeedCountDownload() {
		return needCountDownload;
	}
	
	public void setNeedCount(Type type){
		if(type==Type.DOWNLOAD)
			setNeedCountDownload(true);
		else
			setNeedCountInstall(true);
	}
}
