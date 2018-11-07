package com.speed.service.impl;

import java.util.Date;
import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.speed.model.Admin;
import com.speed.model.AdminRefRole;
import com.speed.model.Entity.AdminCriteria;
import com.speed.model.Entity.AdminRefRoleCriteria;
import com.speed.model.Entity.Value;
import com.speed.model.Logrecord;
import com.speed.service.AdminRefRoleService;
import com.speed.service.AdminService;
import com.speed.service.LogrecordService;
import com.speed.util.CryptUtil;
import com.speed.util.ErrorCode;
import com.speed.util.JsonResult;
import com.speed.util.StringUtil;

@Service
public class AdminServiceImpl extends BaseServiceImpl<Integer, Admin> implements AdminService {
	
	@Autowired
	private AdminRefRoleService adminRefRoleService;
	@Autowired
	private LogrecordService logrecordService;

	public JsonResult Login(String passport, String passwd) throws Exception {
		JsonResult result = new JsonResult();
		if (StringUtil.isBlank(passport)) {
			result.addErrorCode(ErrorCode.SYS_PARAM_VALUE_ERROR);
			return result;
		}
		if (StringUtil.isBlank(passwd)) {
			result.addErrorCode(ErrorCode.SYS_PARAM_VALUE_ERROR);
			return result;
		}
		AdminCriteria criteria = new AdminCriteria();
		criteria.setUserName(Value.eq(passport));
		
		
		//criteria.setUserPwd(Value.eq(passwd));
		criteria.setUserPwd(Value.eq(CryptUtil.md5(passwd)));		
		
		//状态state=1，非冻结
		criteria.setState(Value.eq(1));
		Admin admin = selectOne(criteria);
		if (admin == null) {
			result.addErrorCode(ErrorCode.CUSTOM_USER_PWD_ERROR_LOCK);
			return result;
		}
		//最后登录时间
		admin.setLastLoginTime(new Date());
		Integer upd=update(admin);
		if(upd==null){
			result.addErrorCode(ErrorCode.SYS_ERR);
			return result;
		}
		//添加操作日志记录
		Logrecord logrecord=new Logrecord();
		logrecord.setId(null);
		logrecord.setType(1);
		logrecord.setContent("成功登录系统");
		logrecord.setMakeClass("com.wheat.back.controller.CenterController#getLogin");
		logrecord.setMakePeople(admin.getUserName());
		logrecord.setMakeTime(new Date());		
		logrecordService.save(logrecord);
		result.setData(admin);
		return result;
	}


	public JsonResult saveOrUpdate(Admin admin, Integer[] roleids,String newUserPwd) {
		JsonResult result = new JsonResult();
		if (StringUtil.isBlank(admin.getUserName()) 
				|| StringUtil.isBlank(admin.getPhone()) 
				|| StringUtil.isBlank(admin.getUserPwd())) {
			result.addErrorCode(ErrorCode.SYS_PARAM_VALUE_ERROR);
			return result;
		}
		if (roleids == null || roleids.length < 1) {
			result.addErrorCode(ErrorCode.SYS_PARAM_VALUE_ERROR);
			return result;
		}
		if (StringUtil.isBlank(admin.getId())) {
			// 新增
			// 用户名不能重复
			AdminCriteria criteria = new AdminCriteria();
			criteria.setUserName(Value.eq(admin.getUserName()));
			Admin bean = selectOne(criteria);
			if (bean != null) {
				result.addErrorCode(ErrorCode.CUSTOM_EXIST);
				return result;
			}
			admin.setCreateTime(new Date());
			admin.setState(1);
			
			//user.setPassword(CryptUtil.md5(user.getPassword()));
			//System.out.println("jiami:======================="+CryptUtil.md5(admin.getUserPwd()));
			admin.setUserPwd(CryptUtil.md5(admin.getUserPwd()));
			
			Integer adminId = save(admin);
			if (adminId != null) {
				for (Integer roleId : roleids) {
					AdminRefRole arf = new AdminRefRole();
					arf.setAdminid(adminId);
					arf.setRoleid(roleId);
					adminRefRoleService.save(arf);
				}
			}
		}else {
			// update
			/*if(newUserPwd!=null&&!"".equals(newUserPwd)){
				result.addErrorCode(ErrorCode.SYS_PARAM_VALUE_ERROR);
				return result;
			}*/
			//判断确认密码			
			if(!admin.getUserPwd().equals(newUserPwd)){
				result.addErrorCode(ErrorCode.CUSTOM_PHONE_NOT_DIFFERENT);
				return result;
			}
			admin.setUserPwd(CryptUtil.md5(admin.getUserPwd()));
			int update = update(admin);
			if (update == 1) {
				AdminRefRoleCriteria criteria = new AdminRefRoleCriteria();
				criteria.setAdminid(Value.eq(admin.getId()));
				List<AdminRefRole> refRoles = adminRefRoleService.selectList(criteria);
				for (AdminRefRole ref : refRoles) {
					adminRefRoleService.delete(ref.getId());
				}
				for (Integer roleId : roleids) {
					AdminRefRole arf = new AdminRefRole();
					arf.setAdminid(admin.getId());
					arf.setRoleid(roleId);
					adminRefRoleService.save(arf);
				}
			}
		}
		return result;
	}

}