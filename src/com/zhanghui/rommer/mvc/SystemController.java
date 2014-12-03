package com.zhanghui.rommer.mvc;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.zhanghui.rommer.common.LoginContext;
import com.zhanghui.rommer.common.RequestUtils;
import com.zhanghui.rommer.common.SecurityUtils;
import com.zhanghui.rommer.domain.SysUser;
import com.zhanghui.rommer.service.SysUserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

/**
 * ��¼���ǳ���ϵͳ���õ�
 * @author <a href="pangkunyi@gmail.com">Calvin Pang</a>
 *
 */
@Controller
public class SystemController {
	private final Logger log=LoggerFactory.getLogger(getClass());
	private final static int MAX_SIZE_CACHE=1000;
	private final static int MAX_TIME_RETRY_PER_IP=50;
	private final static int MAX_TIME_RETRY_PER_IP_AND_ACCOUNT=5;
	private final static long EXPIRE_TIME_IN_MINUTES=10L;
	private final Cache<String, Integer> incorrectAccessCache=CacheBuilder.newBuilder().maximumSize(MAX_SIZE_CACHE).expireAfterWrite(EXPIRE_TIME_IN_MINUTES, TimeUnit.MINUTES).<String, Integer>build();
	@Resource
	private SysUserService sysUserService;
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/login";
	}
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){
		return "/system/login";
	}
	@RequestMapping(value="/login",method=RequestMethod.POST,produces="application/javascript;charset=UTF-8")
	public @ResponseBody String login(@RequestParam("username") String username, @RequestParam("passwd") String passwd, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws NoSuchAlgorithmException{
		SysUser sysUser = sysUserService.getByUsername(username);
		String ip=RequestUtils.getRemoteIp(request);
		String ipAccount=ip+"-"+username;
		Integer ipRetryCount = incorrectAccessCache.getIfPresent(ip);
		if(ipRetryCount!=null && ipRetryCount>MAX_TIME_RETRY_PER_IP){
			return  "({\"success\":false,\"msg\":\"��IP�Ѿ�������"+EXPIRE_TIME_IN_MINUTES+"���ӣ�\"})";
		}
		Integer ipAccountRetryAccount = incorrectAccessCache.getIfPresent(ipAccount);
		if(ipAccountRetryAccount!=null && ipAccountRetryAccount>MAX_TIME_RETRY_PER_IP_AND_ACCOUNT){
			return  "({\"success\":false,\"msg\":\"���¼��"+username+"�˺��Ѿ�������"+EXPIRE_TIME_IN_MINUTES+"���ӣ�\"})";
		}
		if(sysUser==null || !SecurityUtils.md5Encode(passwd, username).equals(sysUser.getPasswd())){
			incorrectAccessCache.put(ip, ipRetryCount==null?1:ipRetryCount+1);
			incorrectAccessCache.put(ipAccount, ipAccountRetryAccount==null?1:ipAccountRetryAccount+1);
			log.error("{}[{}] login failed!",username,ip);
			return "({\"success\":false,\"msg\":\"�û������ڻ����벻��ȷ��\"})";
		}
		LoginContext.doLogin(sysUser, session);
		return "({\"success\":true,\"msg\":\"��¼�ɹ���\"})";
	}
}
