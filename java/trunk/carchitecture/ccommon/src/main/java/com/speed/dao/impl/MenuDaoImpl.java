package com.speed.dao.impl;

import java.util.List;

import com.speed.dao.MenuDao;
import com.speed.model.Menu;
import org.springframework.stereotype.Repository;

@Repository
public class MenuDaoImpl extends BaseDaoImpl<Integer, Menu> implements MenuDao {

	@Override
	public List<Menu> getMenusByRoleIds(List<Integer> ids) {
		return sqlSessionTemplate.selectList(statement("getMenusByRoleids"), ids);
	}

}