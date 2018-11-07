package com.speed.util;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 
* @Title: SignEntity.java
* @Package commons.lander.util
* @Description: 涉及到签名的一些信息
* @author chenwenhao 
* @date 2016-12-6 下午1:39:56
 */
@Component
public class SignEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	@Value("${android_client_secret}")
	private String android_client_secret; 	//android私钥
	@Value("${ios_client_secret}")
	private String ios_client_secret;
	//ios私钥
	private String projectName;				//项目名
	
	public String getAndroid_client_secret() {
		return android_client_secret;
	}
	public void setAndroid_client_secret(String android_client_secret) {
		this.android_client_secret = android_client_secret;
	}
	public String getIos_client_secret() {
		return ios_client_secret;
	}
	public void setIos_client_secret(String ios_client_secret) {
		this.ios_client_secret = ios_client_secret;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
}
