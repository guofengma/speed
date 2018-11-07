package com.speed.service.impl;

import com.speed.dao.AppLogDao;
import com.speed.model.AppLog;
import com.speed.service.AppLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppLogServiceImpl extends BaseServiceImpl<Integer, AppLog> implements AppLogService {
	
	@Autowired
	private AppLogDao dao;

}