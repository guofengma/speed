package com.speed.service;

import com.speed.model.RoleRefMenu;
import com.speed.util.JsonResult;


public interface RoleRefMenuService extends BaseService<Integer, RoleRefMenu> {

	JsonResult saveRoleMenuByMgt(Integer[] menuIds, Integer roleId);
}