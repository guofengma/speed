package com.speed.service.impl;

import com.speed.dao.AdminRefRoleDao;
import com.speed.model.AdminRefRole;
import com.speed.service.AdminRefRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminRefRoleServiceImpl extends BaseServiceImpl<Integer, AdminRefRole> implements AdminRefRoleService {
	
	@Autowired
	private AdminRefRoleDao dao;

}