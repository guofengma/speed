package com.speed.model;

public class AppLog implements Entity {
	
	private static final long serialVersionUID = 1L;
	
	/**  */
	protected Integer 主键;
	
	/**  */
	protected java.util.Date 创建时间;
	
	/**  */
	protected String 操作ip;
	
	/**  */
	protected String 日志内容;
	
	/**  */
	protected Integer 日志类型;
	
	/**  */
	protected Integer 用户id;
	
 	public Integer get主键() {
		return 主键;
	}
	
	public void set主键(Integer 主键) {
		this.主键 = 主键;
	}
	
	public java.util.Date get创建时间() {
		return 创建时间;
	}
	
	public void set创建时间(java.util.Date 创建时间) {
		this.创建时间 = 创建时间;
	}
	
	public String get操作ip() {
		return 操作ip;
	}
	
	public void set操作ip(String 操作ip) {
		this.操作ip = 操作ip;
	}
	
	public String get日志内容() {
		return 日志内容;
	}
	
	public void set日志内容(String 日志内容) {
		this.日志内容 = 日志内容;
	}
	
	public Integer get日志类型() {
		return 日志类型;
	}
	
	public void set日志类型(Integer 日志类型) {
		this.日志类型 = 日志类型;
	}
	
	public Integer get用户id() {
		return 用户id;
	}
	
	public void set用户id(Integer 用户id) {
		this.用户id = 用户id;
	}
	
 	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("主键 = ").append(主键).append(", ");
		builder.append("创建时间 = ").append(创建时间).append(", ");
		builder.append("操作ip = ").append(操作ip).append(", ");
		builder.append("日志内容 = ").append(日志内容).append(", ");
		builder.append("日志类型 = ").append(日志类型).append(", ");
		builder.append("用户id = ").append(用户id);
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((主键 == null) ? 0 : 主键.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		AppLog other = (AppLog) obj;
		if (主键 == null) {
			if (other.主键 != null) {
				return false;
			}
		} else if (!主键.equals(other.主键)) {
			return false;
		}
		return true;
	}

}