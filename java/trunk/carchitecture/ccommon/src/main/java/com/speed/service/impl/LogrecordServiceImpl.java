package com.speed.service.impl;

import com.speed.dao.LogrecordDao;
import com.speed.model.Logrecord;
import com.speed.service.LogrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogrecordServiceImpl extends BaseServiceImpl<Integer, Logrecord> implements LogrecordService {
	
	@Autowired
	private LogrecordDao dao;

}