package com.zhanghui.rommer.common;


public class Paginator {
	public final static int DEFAULT_SIZE=12;
	private int start;
	private int size;
	private int page;
    private int total;//�ܼ�¼��
    private boolean needTotal;//�Ƿ���Ҫ�ܼ�¼��
	private boolean hasNextPage;
	private boolean hasPrePage;
	private boolean hasData;
    private boolean pageless;//�Ƿ�Ϊ��ҳ��ѯ(�п������ڵ���ȫ������)
	private String path;
	private Query query;
	
	public Paginator(int page){
		this.page=page;
		init();
	}
	public Paginator(int page, int size){
		this.page=page;
		this.size=size;
		init();
	}
	
	private void init() {
		if(size<1){
			size=DEFAULT_SIZE;
		}
		if(page<1){
			page=1;
		}
		start=(page-1)*size;
		hasPrePage=page>1;
	}

    public boolean isPageless() {
        return pageless;
    }

    public void setPageless(boolean pageless) {
        this.pageless = pageless;
    }

    public boolean isNeedTotal() {
        return needTotal;
    }

    public void setNeedTotal(boolean needTotal) {
        this.needTotal = needTotal;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public SqlFunc getFn(){
        return SqlFunc.get();
    }
	
	public Query getQuery() {
		return query;
	}
	
	public void setQuery(Query query) {
		this.query = query;
	}
	
	public boolean isHasPrePage() {
		return hasPrePage;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public String getPath() {
		return path;
	}
	
	public boolean isHasData() {
		return hasData;
	}
	
	public void setHasData(boolean hasData) {
		this.hasData = hasData;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}
	
	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}
	
	public void setPage(int page) {
		init();
	}
	
	public int getPage() {
		return page;
	}
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getSize() {
		return size;
	}
	/**
	 * ÿ�ζ�ȡһ����¼�����ж��Ƿ�����һҳ
	 * @return
	 */
	public int getSqlSize() {
		return size+1;
	}
	public void setSize(int size) {
		this.size = size;
		init();
	}
}
