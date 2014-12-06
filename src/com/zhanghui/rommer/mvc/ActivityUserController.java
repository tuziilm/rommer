package com.zhanghui.rommer.mvc;

import java.util.Date;

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
import com.zhanghui.rommer.domain.ActivityUser;
import com.zhanghui.rommer.domain.PopInfo;
import com.zhanghui.rommer.service.ActivityUserService;
import com.zhanghui.rommer.service.PopInfoService;

/**
 * 激活量统计入口
 */
@Controller
@RequestMapping("/activityUser")
public class ActivityUserController extends CRUDController<ActivityUser, ActivityUserService, com.zhanghui.rommer.mvc.ActivityUserController.ActivityUserListForm, com.zhanghui.rommer.mvc.ActivityUserController.Query>{
	public ActivityUserController() {
		super("activityUser");
	}
	@Resource
	public void setActivityUserService(ActivityUserService activityUserService){
		this.service=activityUserService;
	}
	
	public static class ActivityUserListForm extends IdForm<ActivityUser> {
		private String channel;
		private String lastShowAdDate;
		private String country;
		private Integer count;
		
		public String getChannel() {
			return channel;
		}

		public void setChannel(String channel) {
			this.channel = channel;
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
		
		public Integer getCount() {
			return count;
		}

		public void setCount(Integer count) {
			this.count = count;
		}

		@Override
		public ActivityUser newObj() {
			return new ActivityUser();
		}

		@Override
		public void populateObj(ActivityUser obj) {
			obj.setChannel(channel);
			obj.setCountry(country);
			obj.setLastShowAdDate(lastShowAdDate);
			obj.setCount(count);
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

	@Override
	public void innerSave(ActivityUserListForm form, BindingResult errors,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
	}
}
