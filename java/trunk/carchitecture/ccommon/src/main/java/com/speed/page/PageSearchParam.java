package com.speed.page;

import java.util.HashMap;
import java.util.Map;

import com.speed.enums.OrderEnum;
/**
 * 分页查询检索参数
 * @author Jan
 *
 */
public class PageSearchParam {
	
	// 当前请求的页码
	private int page;

	// 每页显示的条数
	private int size;

	// 结果的过滤参数
	private Map<String, Object> params = new HashMap<String, Object>();

	// 结果的排序参数
	private Map<String, Object> orders = new HashMap<String, Object>();

	private static final int DEFAULT_PAGE_SIZE = 10;

	public int getPage() {
		return page <= 0 || page > Integer.MAX_VALUE ? 1 : page;
	}

	public void setPage(int currPage) {
		this.page = currPage;
	}

	public int getSize() {
		return size <= 0 || size > Integer.MAX_VALUE ? DEFAULT_PAGE_SIZE : size;
	}

	public void setSize(int pageSize) {
		this.size = pageSize;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	public Map<String, Object> getOrders() {
		return orders;
	}

	public void setOrders(Map<String, Object> orders) {
		this.orders = orders;
	}

	public Map<String, Object> buildQueryParams() {
		params.put("count", getSize());
		params.put("start", (getPage() - 1) * getSize());
		params.put("orderby", orders.isEmpty() ? null : orders);
		return params;
	}

	/**
	 * 设置检索参数
	 * 
	 * @param field
	 *            字段名
	 * @param value
	 *            字段值
	 */
	public void set(String field, Object value) {
		if (field != null) {
			params.put(field, value);
		}
	}

	/**
	 * 排序
	 * 
	 * @param field
	 *            排序字段名
	 * @param orderEnum
	 *            排序关键字
	 */
	public void orderBy(String field, OrderEnum orderEnum) {
		if (field != null) {
			orders.put(field, orderEnum.name());
		}
	}

	@Override
	public String toString() {
		return "PageSearchParam [ page = " + page + ", size = " + size
				+ ", params = " + params + ", orders = " + orders + " ]";
	}
}
