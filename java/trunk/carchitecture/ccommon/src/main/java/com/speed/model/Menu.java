package com.speed.model;

import java.util.ArrayList;
import java.util.List;





public class Menu implements Entity {
	
	private static final long serialVersionUID = 1L;
	
	/**  */
	protected Integer id;
	
	/**  */
	protected java.util.Date creationTime;
	
	/**  */
	protected Integer isleaf;
	
	/**  */
	protected String name;
	
	/**  */
	protected Integer parentId;
	
	/**  */
	protected String parentName;
	
	/**  */
	protected String url;
	
	protected List<Menu> list = new ArrayList<Menu>();
	
 	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public java.util.Date getCreationTime() {
		return creationTime;
	}
	
	public void setCreationTime(java.util.Date creationTime) {
		this.creationTime = creationTime;
	}
	
	public Integer getIsleaf() {
		return isleaf;
	}
	
	public void setIsleaf(Integer isleaf) {
		this.isleaf = isleaf;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getParentId() {
		return parentId;
	}
	
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
	public String getParentName() {
		return parentName;
	}
	
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
 	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("id = ").append(id).append(", ");
		builder.append("creationTime = ").append(creationTime).append(", ");
		builder.append("isleaf = ").append(isleaf).append(", ");
		builder.append("name = ").append(name).append(", ");
		builder.append("parentId = ").append(parentId).append(", ");
		builder.append("parentName = ").append(parentName).append(", ");
		builder.append("url = ").append(url);
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
		Menu other = (Menu) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	public List<Menu> getList() {
		return list;
	}

	public void setList(List<Menu> list) {
		this.list = list;
	}
	
}