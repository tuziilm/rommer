package com.zhanghui.rommer.mvc;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhanghui.rommer.common.Country;
import com.zhanghui.rommer.common.IdForm;
import com.zhanghui.rommer.common.LoginContext;
import com.zhanghui.rommer.common.Paginator;
import com.zhanghui.rommer.domain.PopInfo;
import com.zhanghui.rommer.service.PopInfoService;

/**
 * 销量统计入口
 * @author <a href="pangkunyi@gmail.com">Calvin Pang</a>
 *
 */
@Controller
@RequestMapping("/popInfo")
public class PopInfoController extends CRUDController<PopInfo, PopInfoService, com.zhanghui.rommer.mvc.PopInfoController.PopInfoListForm, com.zhanghui.rommer.mvc.PopInfoController.Query>{
	public PopInfoController() {
		super("popInfo");
	}
	@Resource
	public void setPopInfoService(PopInfoService popInfoService){
		this.service=popInfoService;
	}
	
	public static class PopInfoListForm extends IdForm<PopInfo> {
		private String uuid;
		private String language;
		private String netType;
		private String channel;
		private String isShowAd;
		private String lastShowAdDate;
		private String country;
		private String tableName;
		private String ip;
		
		public String getUuid() {
			return uuid;
		}

		public void setUuid(String uuid) {
			this.uuid = uuid;
		}

		public String getLanguage() {
			return language;
		}

		public void setLanguage(String language) {
			this.language = language;
		}

		public String getNetType() {
			return netType;
		}

		public void setNetType(String netType) {
			this.netType = netType;
		}

		public String getChannel() {
			return channel;
		}

		public void setChannel(String channel) {
			this.channel = channel;
		}

		public String getIsShowAd() {
			return isShowAd;
		}

		public void setIsShowAd(String isShowAd) {
			this.isShowAd = isShowAd;
		}

		public String getLastShowAdDate() {
			return lastShowAdDate;
		}

		public void setLastShowAdDate(String lastShowAdDate) {
			this.lastShowAdDate = lastShowAdDate;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getTableName() {
			return tableName;
		}

		public void setTableName(String tableName) {
			this.tableName = tableName;
		}

		public String getIp() {
			return ip;
		}

		public void setIp(String ip) {
			this.ip = ip;
		}

		@Override
		public PopInfo newObj() {
			return new PopInfo();
		}

		@Override
		public void populateObj(PopInfo obj) {
			obj.setChannel(channel);
			obj.setCountry(country);
			obj.setIp(ip);
			obj.setIsShowAd(isShowAd);
			obj.setLanguage(language);
			obj.setLastShowAdDate(lastShowAdDate);
			obj.setNetType(netType);
			obj.setTableName(tableName);
			obj.setUuid(uuid);
		}
	}

	@Override
	public void innerSave(PopInfoListForm form, BindingResult errors, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		//执行更新或保存的操作
		PopInfo popInfo = form.toObj();
		try{
			service.saveOrUpdate(popInfo);
		}catch(DuplicateKeyException e){
			errors.addError(new ObjectError("database", "代号已经存在！"));
		}
	}
	 @Override
	 protected boolean preList(int page, Paginator paginator, Query query, Model model) {
	       paginator.setNeedTotal(true);//分页
	       model.addAttribute("countries", Country.countries);
	       model.addAttribute("countryMap", Country.shortcut2CountryMap);
	       query.startTime=query.startTime.replace("/", "-");
	       query.endTime=query.endTime.replace("/", "-");
	       if(query.country.equals("all")){
	    	   query.country=null;
	       }
	       return super.preList(page, paginator, query, model);
	   }
	 @Override
	protected void postList(int page, Paginator paginator, Query query,
			Model model) {
		int total = service.countAll(paginator);
		model.addAttribute("total", total);
		super.postList(page, paginator, query, model);
	}
	 public static class Query extends com.zhanghui.rommer.common.Query {
		private String channel;
		private String startTime;
		private String endTime;
		private String country;
		
		public Query() {
			this.startTime = DateFormatUtils.format(DateUtils.addDays(new Date(), -30), "yyyy-MM-dd");
            this.endTime = DateFormatUtils.format(DateUtils.addDays(new Date(), -1), "yyyy-MM-dd");
			if(LoginContext.isAdmin()){
				this.channel=null;
			}else{
				this.channel=LoginContext.getUserChannel();
			}
			setCountry("all");
		}	

		public String getChannel() {
			return channel;
		}

		public void setChannel(String channel) {
			this.channel = channel;
			addItem("channel", channel);
		}

		public String getStartTime() {
			return startTime;
		}

		public void setStartTime(String startTime) {
			this.startTime = startTime;
			addItem("startTime", startTime);
		}

		public String getEndTime() {
			return endTime;
		}

		public void setEndTime(String endTime) {
			this.endTime = endTime;
			addItem("endTime", endTime);
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
			addItem("country",country);
		}
		
	 }
}
