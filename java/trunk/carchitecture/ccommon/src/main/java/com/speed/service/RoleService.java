package com.speed.service;

import com.speed.model.Role;
import com.speed.util.JsonResult;

public interface RoleService extends BaseService<Integer, Role> {

	JsonResult saveOrUpdate(Role role);
}