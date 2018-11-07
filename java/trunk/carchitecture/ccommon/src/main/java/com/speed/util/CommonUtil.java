package com.speed.util;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;

import com.speed.model.Entity;



public class CommonUtil {

	/***
	 * 
	* @Title: CommonUtil.java
	* @Package commons.lander.util
	* @Description: 创建8位数字的用户唯一标识
	* @author chenwenhao 
	* @date 2016-12-1 上午9:01:01
	 */
	public static Integer createUserCode() {
		int i = RandomUtils.nextInt(100000000);
		if (i < 10000000) {
			i += 10000000;
		}
		return i;
	}
	
	/**获取一个?位数字的随机码*/
	public static String createRandomNumeric(int count){
		return RandomStringUtils.randomNumeric(count);
	}
	
	/***
	 * 
	* @Title: CommonUtil.java
	* @Package commons.lander.util
	* @Description: 把List转为Map
	* @author chenwenhao 
	* @date 2016-12-10 上午9:48:54
	 */
/*	public static Map<Serializable,Entity> transformToMap(List<? extends Entity> list){
		Map<Serializable,Entity> map = null;
		if(list!=null && !list.isEmpty()){
			map = new HashMap<Serializable, Entity>();
			for(Entity ent : list){
				map.put(ent.getId(), ent);
			}
		}
		return map;
	}*/
	
	/**
	 * 
	* @Title: CommonUtil.java
	* @Package commons.lander.util
	* @Description: 创建用户token值
	* 				token = userCode+当前时间戳+uuid随机码
	* @author chenwenhao 
	* @date 2016-12-1 上午9:39:21
	 */
	public static String createToken(Integer userCode){
		StringBuilder bulider = new StringBuilder("");
		bulider.append(userCode);
		bulider.append(";");
		bulider.append(System.currentTimeMillis());
		bulider.append(";");
		bulider.append(UUID.randomUUID().toString());
		return RSAUtils.encrypt(bulider.toString(),true);
	}

		
	public static void main(String[] args) {
		System.out.println(createUserCode());
	}
	
	/**
	 * 生成订单号  当前年月日 + 随机9位数
	 * @return
	 */
	public static String createOrderCode(){
		return DateFuncs.toString(new Date(), "yyyyMMdd") + createRandomNumeric(9);
	}
}
