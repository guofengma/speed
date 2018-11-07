package com.speed.service.impl;

import com.speed.dao.AppLoginLogDao;
import com.speed.model.AppLoginLog;
import com.speed.service.AppLoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppLoginLogServiceImpl extends BaseServiceImpl<Integer, AppLoginLog> implements AppLoginLogService {
	
	@Autowired
	private AppLoginLogDao dao;

}