package com.speed.service;

import com.speed.model.Admin;
import com.speed.util.JsonResult;




public interface AdminService extends BaseService<Integer, Admin> {
	JsonResult Login(String passport, String password)  throws Exception;
	
	JsonResult saveOrUpdate(Admin admin, Integer[] roleids,String newUserPwd);
}