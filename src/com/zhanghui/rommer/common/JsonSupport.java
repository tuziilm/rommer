package com.zhanghui.rommer.common;

import org.codehaus.jackson.map.ObjectMapper;

public interface JsonSupport {
	/** ObjectMapper���̰߳�ȫ��*/
	final static ObjectMapper mapper=new ObjectMapper();
	final static String FAIL_JSON="{\"success\":false}";
	final static String SIMPLE_SUCCESS_JSON="{\"success\":true}";
	final static String FAIL_JSONP="({\"success\":false})";
	final static String SIMPLE_SUCCESS_JSONP="({\"success\":true})";
}
