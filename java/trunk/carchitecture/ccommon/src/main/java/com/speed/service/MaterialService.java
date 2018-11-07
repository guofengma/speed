package com.speed.service;

import org.springframework.web.multipart.MultipartFile;


import com.speed.model.Material;
import com.speed.util.JsonResult;

public interface MaterialService extends BaseService<Integer, Material> {
	public JsonResult saveDo(Material material,MultipartFile file);

}