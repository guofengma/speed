package com.speed.util;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;





import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;



public class JsonUtil {
	private static JsonConfig config = new JsonConfig();
	static {
		config.registerJsonValueProcessor(java.util.Date.class,
				new JsonDateValueProcessor());
	}

	public static String toJson(List list) {
		JSONArray arr = JSONArray.fromObject(list, config);
		return arr.toString();
	}

	public static String toJson(Object obj) {
		JSONObject arr = JSONObject.fromObject(obj, config);
		return arr.toString();
	}

	public static JSONObject toJsonObject(Object obj) {
		JSONObject arr = JSONObject.fromObject(obj, config);
		return arr;
	}
	
	
	//test
	public static void main(String[] args) {
		JsonConfig config = new JsonConfig();
		config.registerJsonValueProcessor(java.util.Date.class,
				new JsonDateValueProcessor());
//		Admin s = new Admin();
//		  // long currentTime=System.currentTimeMillis(); 
//	   s.setCreationtime(String.valueOf(System.currentTimeMillis()));
//		JSONObject jsonObject = JSONObject.fromObject(s, config);
//		System.out.println(jsonObject.toString());
//		
//		
//		List list = new ArrayList();
//		list.add(s);
//		System.out.println(JsonUtil.toJson(s));
//		System.out.println(JsonUtil.toJson(list));
//		
//		Map m = new HashMap();
//		m.put("obj", s);
//		m.put("list", list);
//		System.out.println(JsonUtil.toJson(m));
	}

}
