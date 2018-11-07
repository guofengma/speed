package com.speed.service.impl;

import com.speed.dao.MaterialImageDao;
import com.speed.model.MaterialImage;
import com.speed.service.MaterialImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialImageServiceImpl extends BaseServiceImpl<Integer, MaterialImage> implements MaterialImageService {
	
	@Autowired
	private MaterialImageDao dao;

}