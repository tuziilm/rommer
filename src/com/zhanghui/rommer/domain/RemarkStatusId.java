package com.zhanghui.rommer.domain;

/**
 * ����remark, status, id�ֶ�
 * @author <a href="pangkunyi@gmail.com">Calvin Pang</a>
 *
 */
public class RemarkStatusId extends RemarkId{
    /** ״̬,1:����,0:�쳣*/
    protected Byte status;

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
