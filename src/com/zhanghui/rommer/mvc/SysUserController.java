package com.zhanghui.rommer.mvc;

import com.zhanghui.rommer.common.LoginContext;
import com.zhanghui.rommer.common.RemarkForm;
import com.zhanghui.rommer.common.SecurityUtils;
import com.zhanghui.rommer.common.SystemUserType;
import com.zhanghui.rommer.common.Query.NameQuery;
import com.zhanghui.rommer.domain.SysUser;
import com.zhanghui.rommer.service.SysUserService;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DirectFieldBindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.security.NoSuchAlgorithmException;

/**
 * ϵͳ�û��������
 * @author <a href="pangkunyi@gmail.com">Calvin Pang</a>
 *
 */
@Controller
@RequestMapping("/sysuser")
public class SysUserController extends CRUDController<SysUser, SysUserService, com.zhanghui.rommer.mvc.SysUserController.SysUserForm, NameQuery>{
	public SysUserController() {
		super("sysuser");
	}
	@Resource
	public void setSysUserService(SysUserService sysUserService){
		this.service=sysUserService;
	}
	
	@RequestMapping("/index")
	public String index(){
		if(LoginContext.isAdmin()){
			return REDIRECT_LIST_PAGE;
		}else{
			return "redirect:/sysuser/info_modify/"+LoginContext.getUid();
		}
	}
	
	@RequestMapping(value="/info_save",method=RequestMethod.POST)
	public String infoSave(@Valid SysUserForm form,BindingResult errors, Model model) throws NoSuchAlgorithmException{
		model.addAttribute("errors", errors);
		model.addAttribute("form", form);
		model.addAttribute("isUnderUserInfo", true);
		if(!errors.hasErrors()){
			SysUser sysUser=form.toObj();
			if( sysUser.getId()==null || sysUser.getId()<=0 || sysUser.getId().intValue()!=LoginContext.getUid().intValue()){
				errors.addError(new ObjectError("false", "û��Ȩ���޸ģ�"));
			}else{
				//����������ȷ��
				String passwd = form.getPasswd();
				if(passwd!=null &&passwd.length()>0 && (passwd.length()<4 || passwd.length()>20)){
					errors.addError(new ObjectError("passwd", "����ӦΪ4~20���ַ���"));
					model.addAttribute("errors", errors);
					return CREATE_PAGE;
				}
				service.update(sysUser);
				//�޸ĳɹ�,����ת�û��б�
				errors.addError(new ObjectError("success", "�޸ĳɹ���"));
			}
		}
		return CREATE_PAGE;
	}
	

	@Override
	public void innerSave(SysUserForm form, BindingResult errors, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		SysUser sysUser=form.toObj();
		//����������ȷ��
		String passwd = form.getPasswd();
		boolean isModify=sysUser.getId()!=null && sysUser.getId()>0;
		if(passwd==null||passwd.length()<1){
			if(!isModify){
				errors.addError(new ObjectError("passwd", "���벻��Ϊ�գ�"));
				model.addAttribute("errors", errors);
				return;
			}
		}else if(passwd.length()<4 || passwd.length()>20){
			errors.addError(new ObjectError("passwd", "����ӦΪ4~20���ַ���"));
			model.addAttribute("errors", errors);
			return;
		}
		//ִ�и��»򱣴�Ĳ���
		try{
			if(isModify){
				service.update(sysUser);
			}else{
				sysUser.setStatus((byte)1);
				sysUser.setPrivilege("1");
				service.save(sysUser);
			}
		}catch(DuplicateKeyException e){
			errors.addError(new ObjectError("database", "�����Ѿ����ڣ�"));
			model.addAttribute("errors", errors);
		}
	}
	
	@RequestMapping("/info_modify/{id}")
	public String infoModify(@PathVariable("id") int id,Model model){
		model.addAttribute("isUnderUserInfo", true);
		if(!LoginContext.isAdmin()&&LoginContext.getUid().intValue()!=id){
			DirectFieldBindingResult errors=new DirectFieldBindingResult("id","id");
			errors.addError(new ObjectError("false", "û��Ȩ���޸ģ�"));
			model.addAttribute("errors", errors);
			return CREATE_PAGE;
		}
		SysUser sysUser = service.get(id);
		model.addAttribute("form", sysUser);
		return CREATE_PAGE;
	}
	
	public static class SysUserForm extends RemarkForm<SysUser>{
		@NotNull(message="�û�������Ϊ��")
		@Size(min=1,max=20,message="�û�������Ӧ����1-20���ַ�")
		private String username;
		private String passwd;
		private Byte sysUserType;
		private String channel;
        @Override
        public void populateObj(SysUser sysUser) {
            sysUser.setUsername(username);
            SystemUserType sut = SystemUserType.valueOf(sysUserType);
            if(LoginContext.isAdmin()&&sut!=SystemUserType.UNKNOWN){
                sysUser.setSysUserType(sysUserType);
            }
            if(passwd!=null&&passwd.length()>0){
                sysUser.setPasswd(SecurityUtils.md5Encode(passwd, username));
            }
            sysUser.setChannel(channel);
        }

        public Byte getSysUserType() {
			return sysUserType;
		}
		
		public void setSysUserType(Byte sysUserType) {
			this.sysUserType = sysUserType;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPasswd() {
			return passwd;
		}

		public void setPasswd(String passwd) {
			this.passwd = passwd==null?null:passwd.trim();
		}
		
        public String getChannel() {
			return channel;
		}

		public void setChannel(String channel) {
			this.channel = channel;
		}

		@Override
        public SysUser newObj() {
            return new SysUser();
        }
    }
}
