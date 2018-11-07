package com.speed.service.impl;

import com.speed.dao.UserDao;
import com.speed.exception.CommonException;
import com.speed.model.Entity;
import com.speed.model.User;
import com.speed.service.UserService;
import com.speed.util.Md5SaltTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Service
public class UserServiceImpl extends BaseServiceImpl<Integer, User> implements UserService {
	
	@Autowired
	private UserDao dao;

	@Override
	public User login(String phone, String password) throws CommonException, UnsupportedEncodingException, NoSuchAlgorithmException {
		Entity.UserCriteria userCriteria = new Entity.UserCriteria();
		userCriteria.setPhone(Entity.Value.eq(phone));
		User user = selectOne(userCriteria);
		if (user==null){
			throw new CommonException("手机号还未注册","phoneError");
		}else {
			if (Md5SaltTool.validPassword(password,user.getPassword())){
				return user;
			}else {
				throw new CommonException("手机号或者密码错误","pwdError");
			}
		}
	}
}