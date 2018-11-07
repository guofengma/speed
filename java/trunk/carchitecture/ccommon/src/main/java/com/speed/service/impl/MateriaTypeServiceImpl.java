package com.speed.service.impl;

import com.speed.dao.MateriaTypeDao;
import com.speed.model.MateriaType;
import com.speed.service.MateriaTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MateriaTypeServiceImpl extends BaseServiceImpl<Integer, MateriaType> implements MateriaTypeService {
	
	@Autowired
	private MateriaTypeDao dao;

}