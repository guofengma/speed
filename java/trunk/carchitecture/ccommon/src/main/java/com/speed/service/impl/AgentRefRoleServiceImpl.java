package com.speed.service.impl;

import com.speed.dao.AgentRefRoleDao;
import com.speed.model.AgentRefRole;
import com.speed.service.AgentRefRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgentRefRoleServiceImpl extends BaseServiceImpl<Integer, AgentRefRole> implements AgentRefRoleService {
	
	@Autowired
	private AgentRefRoleDao dao;

}