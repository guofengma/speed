package com.speed.model;

public class Logrecord implements Entity {
	
	private static final long serialVersionUID = 1L;
	
	/**  */
	protected Integer id;
	
	/** 日志内容 */
	protected String content;
	
	/**  */
	protected String ip;
	
	/** 执行类 */
	protected String makeClass;
	
	/** 操作人 */
	protected String makePeople;
	
	/** 操作时间 */
	protected java.util.Date makeTime;
	
	/** 类型 */
	protected Integer type;
	
 	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getIp() {
		return ip;
	}
	
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public String getMakeClass() {
		return makeClass;
	}
	
	public void setMakeClass(String makeClass) {
		this.makeClass = makeClass;
	}
	
	public String getMakePeople() {
		return makePeople;
	}
	
	public void setMakePeople(String makePeople) {
		this.makePeople = makePeople;
	}
	
	public java.util.Date getMakeTime() {
		return makeTime;
	}
	
	public void setMakeTime(java.util.Date makeTime) {
		this.makeTime = makeTime;
	}
	
	public Integer getType() {
		return type;
	}
	
	public void setType(Integer type) {
		this.type = type;
	}
	
 	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("id = ").append(id).append(", ");
		builder.append("content = ").append(content).append(", ");
		builder.append("ip = ").append(ip).append(", ");
		builder.append("makeClass = ").append(makeClass).append(", ");
		builder.append("makePeople = ").append(makePeople).append(", ");
		builder.append("makeTime = ").append(makeTime).append(", ");
		builder.append("type = ").append(type);
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Logrecord other = (Logrecord) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

}