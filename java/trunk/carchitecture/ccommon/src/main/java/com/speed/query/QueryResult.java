package com.speed.query;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * @author myq
 * Date: 2008-9-3
 * Time: 19:26:20
 */
public class QueryResult implements Serializable {

	private static final long serialVersionUID = 4289122068530607759L;

	public List<Map<String, Object>> rows;
	
	public Map<String, String> queryMap;
	
	public Map<String, String> getQueryMap() {
		return queryMap;
	}
	public void setQueryMap(Map<String, String> queryMap) {
		this.queryMap = queryMap;
	}
	// for list query
	public List<Map<String, Object>> getRows() {
		return rows;
	}
	public void setRows(List<Map<String, Object>> rows) {
		this.rows = rows;
	}
	public int getRowCount() {
		return rows == null ? 0 : rows.size();
	}

}
