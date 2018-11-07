package com.speed.interfaces.quartz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.speed.util.Redis;

@Component("checkRedisConnect")
public class CheckRedisConnect {

@Autowired
private Redis redis;
	public void check(){
		if (!redis.openConnection()) {
			redis.openConnection();
		}
	}
}
