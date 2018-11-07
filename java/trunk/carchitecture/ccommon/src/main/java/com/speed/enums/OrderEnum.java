package com.speed.enums;

/**
 * 排序
 * @author Jan
 *
 */
public enum OrderEnum {

	ASC, DESC;

	public static OrderEnum fromCode(String code) {
		for (OrderEnum item : OrderEnum.values()) {
			if (item.name().equalsIgnoreCase(code)) {
				return item;
			}
		}
		return null;
	}
}
