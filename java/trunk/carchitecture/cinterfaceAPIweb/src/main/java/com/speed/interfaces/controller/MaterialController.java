package com.speed.interfaces.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.speed.model.Entity;
import com.speed.model.Entity.MaterialImageCriteria;
import com.speed.model.MateriaType;
import com.speed.model.Entity.MaterialCriteria;
import com.speed.model.Material;
import com.speed.model.MaterialImage;
import com.speed.service.MateriaTypeService;
import com.speed.service.MaterialImageService;
import com.speed.service.MaterialService;
import com.speed.util.JsonResult;
/**
 * 根据类型获取素材信息
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="/material")
public class MaterialController {
	@Autowired
	private MateriaTypeService service;
	@Autowired
	private MaterialService materialService;
	@Autowired
	private MaterialImageService imageService;
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public @ResponseBody JsonResult list(Integer typeId){
		JsonResult result=new JsonResult();
		//根据该类型素材库信息
		MaterialCriteria criteria=new MaterialCriteria();
		criteria.setTypeId(Entity.Value.eq(typeId));
		List<Material> materials=materialService.selectList(criteria);
		List list=new ArrayList();
		for(int i=0;i<materials.size();i++){
			String title=materials.get(i).getTitle();
			String content=materials.get(i).getContent();
			MaterialImageCriteria imageCriteria=new MaterialImageCriteria();
			imageCriteria.setMaterialId(Entity.Value.eq(materials.get(i).getId()));
			List<MaterialImage> images=imageService.selectList(imageCriteria);
			Map urlMap=new HashMap();
			Map map=new HashMap();
			map.put("title", title);
			map.put("content", content);
			List list2=new ArrayList();
			/*if(images.size()>0){
				map.put("img", images.get(0).getImageUrl());
			}*/						
			for(int j=0;j<images.size();j++){
				list2.add(images.get(j).getImageUrl());
			}
			map.put("img", list2);
			list.add(i, map);
		}
		result.setData(list);
		return result;		
	}
}
