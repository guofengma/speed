package com.speed.page;

import java.util.List;

public interface ResultSetConvertor<T> {

	/**
	 * 结果列表转换
	 * 
	 * @param list
	 *            结果列表对象
	 * @return
	 */
	List<?> convert(List<T> list);
}
