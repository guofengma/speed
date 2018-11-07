package com.speed.interfaces.controller;

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
import com.speed.service.AdminService;
import com.speed.util.JsonResult;


@Controller
public class AdminController {
	
  @Autowired
  private AdminService adminService;
    
    //http://localhost:8085/apiweb/login.do?passport=admin&passwd=1234
	@RequestMapping(value="/login",method= RequestMethod.GET)
	public @ResponseBody JsonResult login(String passport,String passwd, HttpServletRequest request)  throws Exception{
		
		JsonResult u = adminService.Login(passport, passwd);
		return u;
	}
	
	@RequestMapping(value="/list",method= RequestMethod.GET)
	public @ResponseBody JsonResult list(HttpServletRequest request, Pagination pagination) {
		JsonResult u = new JsonResult();
		AdminCriteria criteria = new AdminCriteria();
        pagination.openHumpSwitch();
        Pagination list = adminService.selectPage(criteria, pagination);
        u.setData(list);
		System.out.print(u);
		return u;
	}
	//http://192.168.1.173:8085/apiweb/save.do?passport=admin&passwd=1234
	/**
	 * 增
	 * @param request
	 * @param admin
	 * @return
	 */
	@RequestMapping(value="/save",method= RequestMethod.POST)
	public @ResponseBody JsonResult save(HttpServletRequest request, Admin admin) {
		JsonResult u = new JsonResult();
		u.setData(adminService.save(admin));
		System.out.print(u);
		return u;
	}
	
	/**
	 * 改
	 * @param admin
	 * @return
	 */
	@RequestMapping(value="/update",method= RequestMethod.POST)
	public @ResponseBody JsonResult update(Admin admin) {
		JsonResult u = new JsonResult();
		//根据主键修改(必须要有ID)
		//int update = adminService.update(admin);
		
		//根据条件修改
		AdminCriteria criteria = new AdminCriteria();
		// 修改passport为Jan的所有
		criteria.setUserName(Value.eq("Jan"));
		int update = adminService.update(admin, criteria);
		u.setData(update);
		System.out.print(u);
		return u;
	}
	
	@RequestMapping(value="/delete",method= RequestMethod.POST)
	public @ResponseBody JsonResult delete(Admin admin) {
		JsonResult u = new JsonResult();
		//根据主键删除
		int result = adminService.delete(admin.getId());
		
		// 根据条件删除
		AdminCriteria criteria = new AdminCriteria();
		criteria.setUserName(Value.eq("Jan"));
		//int result = adminService.delete(criteria);
		u.setData(result);
		System.out.print(u);
		return u;
	}
}
