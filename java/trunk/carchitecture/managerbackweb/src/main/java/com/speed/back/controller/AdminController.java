package com.speed.back.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.speed.model.Admin;
import com.speed.model.Entity.AdminCriteria;
import com.speed.model.Entity.Pagination;
import com.speed.model.Entity.Value;
import com.speed.model.Role;
import com.speed.service.AdminService;
import com.speed.service.RoleService;
import com.speed.util.CryptUtil;
import com.speed.util.ErrorCode;
import com.speed.util.JsonResult;

@Controller
@RequestMapping("adminMgt")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private RoleService roleService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(HttpServletRequest request, Admin bean, Pagination pagination) {
		AdminCriteria criteria = new AdminCriteria();
		if (bean.getUserName() != null && !bean.getUserName().equals("")) {
			criteria.setUserName(Value.eq(bean.getUserName()));
		}
		Pagination list = adminService.selectPage(criteria, pagination);
		request.setAttribute("pagination", list);
		request.setAttribute("bean", bean);
		return "admin/list";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(HttpServletRequest request) {
		List<Role> roles = roleService.selectAll();
		request.setAttribute("roles", roles);
		return "admin/view";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody JsonResult save(Admin admin, Integer[] roleids,String newUserPwd) {
		return adminService.saveOrUpdate(admin, roleids,newUserPwd);
	}
	//进入修改密码页面
		@RequestMapping(value = "/passEdit", method = RequestMethod.GET)
		public String passEdit(HttpServletRequest request) {
			Admin admin=(Admin) request.getSession().getAttribute("USER");
			request.setAttribute("bean", admin);
			return "admin/passView";
		}
		//修改密码功能
		@RequestMapping(value = "/replace", method = RequestMethod.POST)
		public @ResponseBody JsonResult save(Admin admin,String newUserPwd) {
			JsonResult result=new JsonResult();
			if(admin!=null&&admin.getUserPwd()==null||"".equals(admin.getUserPwd())){
				result.addErrorCode(ErrorCode.SYS_PARAM_VALUE_ERROR);
				return result;			
			}
			if(newUserPwd==null||"".equals(newUserPwd)){
				result.addErrorCode(ErrorCode.SYS_PARAM_VALUE_ERROR);
				return result;
			}
			//判断确认密码			
			if(!admin.getUserPwd().equals(newUserPwd)){
				result.addErrorCode(ErrorCode.CUSTOM_PHONE_NOT_DIFFERENT);
				return result;
			}
			admin.setUserPwd(CryptUtil.md5(admin.getUserPwd()));//加密
			Integer num=adminService.update(admin);
			if(num==null){
				result.addErrorCode(ErrorCode.SYS_ERR);
				return result;
			}
			return result;
		}
}
