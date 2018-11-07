package com.speed.interfaces.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.speed.model.MateriaType;
import com.speed.service.MateriaTypeService;
import com.speed.util.JsonResult;
/**
 * 获取素材类型
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="/materiaType")
public class MateriaTypeController {
	@Autowired
	private MateriaTypeService service;
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public @ResponseBody JsonResult list(){
		JsonResult result=new JsonResult();
		List<MateriaType> materiaTypes=service.selectAll();
		result.setData(materiaTypes);
		return result;
	}
}
