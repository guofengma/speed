package com.speed.dao;

import java.util.List;

import com.speed.model.Menu;

public interface MenuDao extends BaseDao<Integer, Menu> {
	
	List<Menu> getMenusByRoleIds(List<Integer> ids);
}