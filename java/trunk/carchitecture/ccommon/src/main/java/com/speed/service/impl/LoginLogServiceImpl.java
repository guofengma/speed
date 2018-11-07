package com.speed.service.impl;

import com.speed.dao.LoginLogDao;
import com.speed.model.LoginLog;
import com.speed.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginLogServiceImpl extends BaseServiceImpl<Integer, LoginLog> implements LoginLogService {
	
	@Autowired
	private LoginLogDao dao;

}