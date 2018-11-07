package com.speed.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.speed.model.User;

public class UserUtil {
	
	@Autowired
	private Redis redis;
	
	@Autowired
	private HttpServletRequest request;
	
	public User getUser(){
		Integer id = (Integer) request.getAttribute("userId");
		return redis.get(String.format(RedisKey.USER, String.valueOf(id)), User.class);
	}
	
	public Integer getUserId(){
		Integer id = (Integer) request.getAttribute("userId");
		return id;
	}
	
}
