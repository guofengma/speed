package com.speed.back.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.speed.model.Entity.MateriaTypeCriteria;
import com.speed.model.Entity.Pagination;
import com.speed.model.MateriaType;
import com.speed.service.MateriaTypeService;
import com.speed.util.ErrorCode;
import com.speed.util.JsonResult;


/**
 * 素材库类型
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="/materiaType")
public class MateriaTypeController {
	@Autowired
	private MateriaTypeService materiaTypeService;
	/**
	 * 获取素材库类型列表
	 * @param request
	 * @param pagination
	 * @return
	 */
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(HttpServletRequest request,Pagination pagination){		
		MateriaTypeCriteria criteria=new MateriaTypeCriteria();
		Pagination list=materiaTypeService.selectPage(criteria, pagination);
		request.setAttribute("pagination", list);
		return "materiaType/list";
	}
	/**
	 * 跳转到增加页面
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(){
		return "materiaType/view";
	}
	/**
	 * 保存或者修改
	 * @param protype
	 * @return
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public @ResponseBody JsonResult save(MateriaType bean){	
		JsonResult result=new JsonResult();
		if(bean!=null&&bean.getId()==null){
			Integer addRum=materiaTypeService.save(bean);
			if(addRum==null){
				result.addErrorCode(ErrorCode.SYS_ERR);
				return result;
			}
			return result;		
		}
		Integer upNum=materiaTypeService.update(bean);
		if(upNum==null){
			result.addErrorCode(ErrorCode.SYS_ERR);
			return result;
		}
		return result;
	}
	/**
	 * 跳转到修改页面
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String edit(HttpServletRequest request,Integer id){
		MateriaType bean=materiaTypeService.selectOne(id);
		request.setAttribute("bean", bean);
		return "materiaType/view";
	}
	/**
	 * 删除类型
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/del",method=RequestMethod.POST)
	public @ResponseBody JsonResult delete(Integer id){
		JsonResult result=new JsonResult();
		Integer delNum=materiaTypeService.delete(id);
		if(delNum==null){
			result.addErrorCode(ErrorCode.SYS_ERR);
			return result;
		}
		return result;
	}
}
