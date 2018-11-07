package com.speed.util;

import org.fanlychie.mybatis.TemplateGenerator;

/**
 * 自动生成代码工具类
 * @author Jan
 *
 */
public class MybatisCreteCodeUtil {
	
	public static void main(String[] args) {
		
		try {
			TemplateGenerator.generate();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
