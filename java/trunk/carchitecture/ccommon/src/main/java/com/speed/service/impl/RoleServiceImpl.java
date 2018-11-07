package com.speed.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.speed.dao.RoleDao;
import com.speed.model.Entity.RoleCriteria;
import com.speed.model.Entity.Value;
import com.speed.model.Role;
import com.speed.service.RoleService;
import com.speed.util.ErrorCode;
import com.speed.util.JsonResult;
import com.speed.util.StringUtil;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Integer, Role> implements RoleService {
	
	@Override
	public JsonResult saveOrUpdate(Role role) {
		JsonResult result = new JsonResult();
		if (StringUtil.isBlank(role.getRoleName())) {
			result.addErrorCode(ErrorCode.SYS_PARAM_VALUE_ERROR);
			return result;
		}
		if (StringUtil.isBlank(role.getId())) {
			// 新增
			// 角色名不能重复
			RoleCriteria criteria = new RoleCriteria();
			criteria.setRoleName(Value.eq(role.getRoleName()));
			Role bean = selectOne(criteria);
			if (bean != null) {
				result.addErrorCode(ErrorCode.ROLENAME_EXITS);
				return result;
			}
			role.setCreateTime(new Date());
			role.setStatus(1);
			save(role);
		}else {
			// update
			update(role);
		}
		return result;
	}

}