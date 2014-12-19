package com.zhanghui.rommer.mvc;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhanghui.rommer.common.IdForm;
import com.zhanghui.rommer.common.Paginator;
import com.zhanghui.rommer.common.Query;
import com.zhanghui.rommer.domain.Rate;
import com.zhanghui.rommer.service.RateService;

/**
 * 扣量入口
 * @author <a href="pangkunyi@gmail.com">Calvin Pang</a>
 *
 */
@Controller
@RequestMapping("/rate")
public class RateController extends CRUDController<Rate, RateService, com.zhanghui.rommer.mvc.RateController.RateForm, Query.NameQuery>{
	public RateController() {
		super("rate");
	}
	@Resource
	public void setRateService(RateService rateService){
		this.service=rateService;
	}
	
	public static class RateForm extends IdForm<Rate> {
		private double info;
		
		public double getInfo() {
			return info;
		}

		public void setInfo(double info) {
			this.info = info;
		}

		@Override
		public Rate newObj() {
			return new Rate();
		}

		@Override
		public void populateObj(Rate obj) {
			obj.setInfo(info);
		}
	}

	@Override
	public void innerSave(RateForm form, BindingResult errors, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		//执行更新或保存的操作
		Rate rate = form.toObj();
		try{
			service.saveOrUpdate(rate);
		}catch(DuplicateKeyException e){
			errors.addError(new ObjectError("database", "代号已经存在！"));
		}
	}
	 @Override
	 protected boolean preList(int page, Paginator paginator, Query.NameQuery query, Model model) {
	       paginator.setNeedTotal(true);//分页
	       return super.preList(page, paginator, query, model);
	   }
	 
}
