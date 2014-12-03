package com.zhanghui.rommer.common;

import org.springframework.util.DigestUtils;

/**
 * ��ȫ��ع�����
 * @author <a href="pangkunyi@gmail.com">Calvin Pang</a>
 *
 */
public class SecurityUtils {
	/**
	 * ʹ��md5�㷨�����ִ�
	 * @param text
	 * @param salt
	 * @return
	 */
	public static String md5Encode(String text, String salt){
		return md5Encode(text,salt.hashCode());
	}
	/**
	 * ʹ��md5�㷨�����ִ�
	 * @param text
	 * @param salt
	 * @return
	 */
	public static String md5Encode(String text, int salt){
		String hexString=new String(DigestUtils.md5DigestAsHex(text.getBytes()));
		String first=hexString.substring(0,15);
		String second=hexString.substring(17);
		Long firstLong = Long.valueOf(first, 16)+salt;
		Long secondLong = Long.valueOf(second, 16)+salt;
		first=Long.toString(firstLong, 16);
		second=Long.toString(secondLong, 16);
		hexString=first+hexString.substring(15,17)+second;
		return new String(DigestUtils.md5DigestAsHex(hexString.getBytes()));
	}
	/**
	 * md5ժҪ
	 * @param text
	 * @return
	 */
	public static String md5Encode(String text){
		return new String(DigestUtils.md5DigestAsHex(text.getBytes()));
	}
	
	public static void main(String[] args){
		System.out.println(md5Encode("1234", "calvin"));
	}
}
