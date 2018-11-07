package com.speed.back.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.speed.model.Entity.By;
import com.speed.model.Entity.LogrecordCriteria;
import com.speed.model.Entity.Pagination;
import com.speed.model.Entity.Value;
import com.speed.model.Logrecord;
import com.speed.service.LogrecordService;


/**
 * 日志记录列表
 * @author Administrator
 *
 */
@Controller
@RequestMapping("Logrecord")
public class LogrecordController {
	@Autowired
	private LogrecordService logrecordService;
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(HttpServletRequest request, Logrecord bean, Pagination pagination){
		LogrecordCriteria criteria = new LogrecordCriteria();
		//按照操作时间倒序	
		criteria.setMakeTime(Value.orderBy(By.DESC));
		
		Pagination list = logrecordService.selectPage(criteria, pagination);
		request.setAttribute("pagination", list);		
		return "logrecord/list";
	}
}
