package com.speed.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Entity extends Serializable {
	
	public static class SimpleCriteria extends GeneralCriteria {

		public Criteria eq(String field, Object value) {
			criterions.add(new Criterion(field, Condition.EQ, value));
			return this;
		}

		public Criteria ne(String field, Object value) {
			criterions.add(new Criterion(field, Condition.NE, value));
			return this;
		}

		public Criteria ge(String field, Object value) {
			criterions.add(new Criterion(field, Condition.GE, value));
			return this;
		}

		public Criteria gt(String field, Object value) {
			criterions.add(new Criterion(field, Condition.GT, value));
			return this;
		}

		public Criteria le(String field, Object value) {
			criterions.add(new Criterion(field, Condition.LE, value));
			return this;
		}

		public Criteria lt(String field, Object value) {
			criterions.add(new Criterion(field, Condition.LT, value));
			return this;
		}

		public Criteria isNull(String field) {
			criterions.add(new Criterion(field, Condition.IS_NULL));
			return this;
		}

		public Criteria isNotNull(String field) {
			criterions.add(new Criterion(field, Condition.IS_NOT_NULL));
			return this;
		}

		public Criteria between(String field, Object v1, Object v2) {
			criterions.add(new Criterion(field, Condition.BETWEEN, v1, v2));
			return this;
		}

		public Criteria like(String field, Object value) {
			criterions.add(new Criterion(field, Condition.LIKE, value));
			return this;
		}

		public Criteria orderBy(String field, By by) {
			orderbies.add(new OrderBy(field, by));
			return this;
		}

		public Criteria orderBy(String field, String order) {
			orderbies.add(new OrderBy(field, order));
			return this;
		}

		public Criteria limit(int offset, int count) {
			limit = new Limit(offset, count);
			return this;
		}

		public <T> Criteria in(String field, @SuppressWarnings("unchecked") T... values) {
			criterions.add(new Criterion(field, Condition.IN, values));
			return this;
		}

		public <T> Criteria notIn(String field, @SuppressWarnings("unchecked") T... values) {
			criterions.add(new Criterion(field, Condition.NOT_IN, values));
			return this;
		}

		@Override
		public String toString() {
			return "limit=" + limit + ", criterions=" + criterions + ", orderbies=" + orderbies;
		}

	}
	
	public static abstract class GeneralCriteria implements Criteria {
		
		protected Limit limit;

		protected Set<OrderBy> orderbies = new LinkedHashSet<OrderBy>();

		protected Set<Criterion> criterions = new LinkedHashSet<Criterion>();

		@Override
		public boolean isOrderly() {
			return orderbies.size() > 0;
		}

		@Override
		public boolean isNotEmpty() {
			return criterions.size() > 0;
		}

		@Override
		public boolean isPagination() {
			return limit != null;
		}

		@Override
		public Limit getLimit() {
			return limit;
		}

		@Override
		public Set<OrderBy> getOrderbies() {
			return orderbies;
		}

		@Override
		public Set<Criterion> getCriterions() {
			return criterions;
		}

		@Override
		public Criteria addCriterion(Criterion criterion) {
			if (criterion instanceof Limit) {
				limit = (Limit) criterion;
			}
			else if (criterion instanceof OrderBy) {
				orderbies.add((OrderBy) criterion);
			}
			else {
				criterions.add(criterion);
			}
			return this;
		}

		@Override
		public Map<String, Object> toMapParameter() {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("criteria", this);
			return param;
		}
		
	}

	public static class Criterion {

		String field;

		Object value, value2;

		private String condition;

		private boolean noValue;

		private boolean singleValue;

		private boolean listValue;

		private boolean betweenValue;

		public String getField() {
			return field;
		}

		public Object getValue() {
			return value;
		}

		public Object getValue2() {
			return value2;
		}

		public String getCondition() {
			return condition;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		Criterion setField(String field) {
			this.field = field;
			return this;
		}

		Criterion() {

		}

		Criterion(Condition condition) {
			this((String) null, condition);
		}

		Criterion(Condition condition, Object value) {
			this((String) null, condition, value);
		}

		Criterion(Condition condition, Object value, Object value2) {
			this(null, condition, value, value2);
		}

		public Criterion(String field, Condition condition) {
			this.field = field;
			this.noValue = true;
			this.condition = condition.toSymbol();
		}

		public Criterion(String field, Condition condition, Object value) {
			this.field = field;
			this.value = value;
			this.condition = condition.toSymbol();
			if (value instanceof Collection || value.getClass().isArray()) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		public Criterion(String field, Condition condition, Object value, Object value2) {
			this.value = value;
			this.value2 = value2;
			this.betweenValue = true;
			this.condition = condition.toSymbol();
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((condition == null) ? 0 : condition.hashCode());
			result = prime * result + ((field == null) ? 0 : field.hashCode());
			result = prime * result + ((value == null) ? 0 : value.hashCode());
			result = prime * result + ((value2 == null) ? 0 : value2.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Criterion other = (Criterion) obj;
			if (condition == null) {
				if (other.condition != null)
					return false;
			} else if (!condition.equals(other.condition))
				return false;
			if (field == null) {
				if (other.field != null)
					return false;
			} else if (!field.equals(other.field))
				return false;
			if (value == null) {
				if (other.value != null)
					return false;
			} else if (!value.equals(other.value))
				return false;
			if (value2 == null) {
				if (other.value2 != null)
					return false;
			} else if (!value2.equals(other.value2))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Criterion [field=" + field + ", value=" + value + ", value2=" + value2 + ", condition=" + condition + "]";
		}

	}

	public static class Limit extends Criterion {

		public Limit(int offset, int count) {
			this.value = offset;
			this.value2 = count;
		}

		@Override
		public String toString() {
			return "Limit [" + value + ", " + value2 + "]";
		}

	}

	public static class OrderBy extends Criterion {
		
		OrderBy(By by) {
			this(null, by);
		}
		
		OrderBy(String order) {
			this(null, order);
		}

		public OrderBy(String field, By by) {
			this(field, by.name());
		}

		public OrderBy(String field, String order) {
			this.field = field;
			this.value = order;
		}

		@Override
		public String toString() {
			return "OrderBy [field=" + field + ", value=" + value + "]";
		}

	}

	public static enum Condition {

		EQ("="),

		GT(">"),

		LT("<"),

		LE("<="),

		NE("!="),

		GE(">="),

		IN("IN"),

		LIKE("LIKE"),

		NOT_IN("NOT IN"),

		BETWEEN("BETWEEN"),

		IS_NULL("IS NULL"),

		IS_NOT_NULL("IS NOT NULL"),

		;

		private final String symbol;

		private Condition(String symbol) {
			this.symbol = symbol;
		}

		public String toSymbol() {
			return symbol;
		}

	}

	public static class Value {

		public static Criterion eq(Object value) {
			return new Criterion(Condition.EQ, value);
		}

		public static Criterion ne(Object value) {
			return new Criterion(Condition.NE, value);
		}

		public static Criterion ge(Object value) {
			return new Criterion(Condition.GE, value);
		}

		public static Criterion gt(Object value) {
			return new Criterion(Condition.GT, value);
		}

		public static Criterion le(Object value) {
			return new Criterion(Condition.LE, value);
		}

		public static Criterion lt(Object value) {
			return new Criterion(Condition.LT, value);
		}

		public static Criterion isNull() {
			return new Criterion(Condition.IS_NULL);
		}

		public static Criterion isNotNull() {
			return new Criterion(Condition.IS_NOT_NULL);
		}

		public static Criterion between(Object v1, Object v2) {
			return new Criterion(Condition.BETWEEN, v1, v2);
		}

		public static Criterion like(Object value) {
			return new Criterion(Condition.LIKE, value);
		}

		public static Criterion orderBy(By by) {
			return new OrderBy(by);
		}

		public static Criterion orderBy(String order) {
			return new OrderBy(order);
		}

		public static <T> Criterion in(@SuppressWarnings("unchecked") T... values) {
			return new Criterion(Condition.IN, values);
		}

		public static <T> Criterion notIn(@SuppressWarnings("unchecked") T... values) {
			return new Criterion(Condition.NOT_IN, values);
		}

	}

	public static enum By { ASC, DESC }

	public static interface Criteria {
		
		boolean isOrderly();
		
		boolean isNotEmpty();
		
		boolean isPagination();
		
		Limit getLimit();
		
		Set<OrderBy> getOrderbies();
		
		Set<Criterion> getCriterions();

		Criteria addCriterion(Criterion criterion);
		
		Map<String, Object> toMapParameter();
		
	}

	public static class PrimaryKey {
		
		private String name;
		
		private Object value;
		
		public static PrimaryKey of(Object obj) {
			Entity entity = null;
			Class<?> entityClass = null;
			if (obj instanceof Entity) {
				entity = (Entity) obj;
				entityClass = entity.getClass();
			}
			else if (obj instanceof Class) {
				entityClass = (Class<?>) obj;
			}
			PrimaryKey primaryKey = new PrimaryKey();
			if (entity == null && entityClass == null) {
				return null;
			}
			else if (entityClass == Admin.class) {
				primaryKey.name = "id";
				if (entity != null) {
					primaryKey.value = ((Admin) entity).getId();
				}
			}
			else if (entityClass == AdminRefRole.class) {
				primaryKey.name = "id";
				if (entity != null) {
					primaryKey.value = ((AdminRefRole) entity).getId();
				}
			}
			else if (entityClass == AppLog.class) {
				primaryKey.name = "主键";
				if (entity != null) {
					primaryKey.value = ((AppLog) entity).get主键();
				}
			}
			else if (entityClass == AppLoginLog.class) {
				primaryKey.name = "id";
				if (entity != null) {
					primaryKey.value = ((AppLoginLog) entity).getId();
				}
			}
			else if (entityClass == Logrecord.class) {
				primaryKey.name = "id";
				if (entity != null) {
					primaryKey.value = ((Logrecord) entity).getId();
				}
			}
			else if (entityClass == MateriaType.class) {
				primaryKey.name = "id";
				if (entity != null) {
					primaryKey.value = ((MateriaType) entity).getId();
				}
			}
			else if (entityClass == Material.class) {
				primaryKey.name = "id";
				if (entity != null) {
					primaryKey.value = ((Material) entity).getId();
				}
			}
			else if (entityClass == MaterialImage.class) {
				primaryKey.name = "id";
				if (entity != null) {
					primaryKey.value = ((MaterialImage) entity).getId();
				}
			}
			else if (entityClass == Menu.class) {
				primaryKey.name = "id";
				if (entity != null) {
					primaryKey.value = ((Menu) entity).getId();
				}
			}
			else if (entityClass == Role.class) {
				primaryKey.name = "id";
				if (entity != null) {
					primaryKey.value = ((Role) entity).getId();
				}
			}
			else if (entityClass == RoleRefMenu.class) {
				primaryKey.name = "id";
				if (entity != null) {
					primaryKey.value = ((RoleRefMenu) entity).getId();
				}
			}
			else if (entityClass == User.class) {
				primaryKey.name = "id";
				if (entity != null) {
					primaryKey.value = ((User) entity).getId();
				}
			}
			return primaryKey;
		}
		
		public static void set(Object obj, Object value) {
			if (obj == null) {
				return ;
			}
			Class<?> entityClass = obj.getClass();
			if (value == null) {
				return ;
			}
			else if (entityClass == Admin.class) {
				((Admin) obj).setId((Integer) value);
			}
			else if (entityClass == AdminRefRole.class) {
				((AdminRefRole) obj).setId((Integer) value);
			}
			else if (entityClass == AppLog.class) {
				((AppLog) obj).set主键((Integer) value);
			}
			else if (entityClass == AppLoginLog.class) {
				((AppLoginLog) obj).setId((Integer) value);
			}
			else if (entityClass == Logrecord.class) {
				((Logrecord) obj).setId((Integer) value);
			}
			else if (entityClass == MateriaType.class) {
				((MateriaType) obj).setId((Integer) value);
			}
			else if (entityClass == Material.class) {
				((Material) obj).setId((Integer) value);
			}
			else if (entityClass == MaterialImage.class) {
				((MaterialImage) obj).setId((Integer) value);
			}
			else if (entityClass == Menu.class) {
				((Menu) obj).setId((Integer) value);
			}
			else if (entityClass == Role.class) {
				((Role) obj).setId((Integer) value);
			}
			else if (entityClass == RoleRefMenu.class) {
				((RoleRefMenu) obj).setId((Integer) value);
			}
			else if (entityClass == User.class) {
				((User) obj).setId((Integer) value);
			}
		}

		public String getName() {
			return name;
		}

		public Object getValue() {
			return value;
		}
		
	}
	
	public static class Pagination {
		
		// 查询结果的总行数
		private long total;
		
		// 当前页的行对象列表
		private List<?> rows;
		
		// 每页显示的行数
		private int limit;
		
		// 起始索引的数值
		private int offset;
		
		// 排序字段名称
		private String sort;
		
		// 排序, ASC, DESC
		private String order;
		
		// 检索字段名
		private String field;
		
		// 检索字符串
		private String search;
		
		// 当前页
		private int page;
		
		// 上一页
		private int prev;
		
		// 下一页
		private int next;
		
		// 总页数
		private int pages;
		
		// 检索参数
		private Map<String, String> params;

		public long getTotal() {
			return total;
		}

		public void setTotal(long total) {
			this.total = total;
		}

		public List<?> getRows() {
			return rows;
		}

		public void setRows(List<?> rows) {
			this.rows = rows;
		}

		public int getLimit() {
			return limit;
		}

		public void setLimit(int limit) {
			this.limit = limit;
		}

		public int getOffset() {
			return offset;
		}

		public void setOffset(int offset) {
			this.offset = offset;
		}

		public String getSort() {
			return sort;
		}

		public void setSort(String sort) {
			this.sort = sort;
		}

		public String getOrder() {
			return order;
		}

		public void setOrder(String order) {
			this.order = order;
		}

		public String getSearch() {
			return search;
		}

		public void setSearch(String search) {
			this.search = search;
		}

		public String getField() {
			return field;
		}

		public void setField(String field) {
			this.field = field;
		}

		public int getPage() {
			return page;
		}

		public void setPage(int page) {
			this.page = page;
		}

		public int getPrev() {
			return prev;
		}

		public void setPrev(int prev) {
			this.prev = prev;
		}

		public int getNext() {
			return next;
		}

		public void setNext(int next) {
			this.next = next;
		}

		public int getPages() {
			return pages;
		}

		public void setPages(int pages) {
			this.pages = pages;
		}

		public Map<String, String> getParams() {
			return params;
		}

		public void setParams(Map<String, String> params) {
			this.params = params;
		}
		
		public void openHumpSwitch() {
			if (sort != null) {
				char ch;
				StringBuilder builder = new StringBuilder();
				for (int i = 0; i < sort.length(); i++) {
					ch = sort.charAt(i);
					if (Character.isUpperCase(ch)) {
						builder.append("_").append((char) (ch + 32));
					}
					else {
						builder.append(ch);
					}
				}
				sort = builder.toString();
			}
		}

		@Override
		public String toString() {
			return "Pagination [total=" + total + ", rows=" + rows + ", limit=" + limit + ", offset=" + offset
					+ ", sort=" + sort + ", order=" + order + ", field=" + field + ", search=" + search + ", page="
					+ page + ", prev=" + prev + ", next=" + next + ", pages=" + pages + ", params=" + params + "]";
		}
		
	}

	public static class AdminCriteria extends SimpleCriteria {
		
		public void setId(Criterion criterion) {
			this.addCriterion(criterion.setField("id"));
		}
		
		public void setCreateTime(Criterion criterion) {
			this.addCriterion(criterion.setField("create_time"));
		}
		
		public void setLastLoginTime(Criterion criterion) {
			this.addCriterion(criterion.setField("last_login_time"));
		}
		
		public void setPhone(Criterion criterion) {
			this.addCriterion(criterion.setField("phone"));
		}
		
		public void setState(Criterion criterion) {
			this.addCriterion(criterion.setField("state"));
		}
		
		public void setUserName(Criterion criterion) {
			this.addCriterion(criterion.setField("user_name"));
		}
		
		public void setUserPwd(Criterion criterion) {
			this.addCriterion(criterion.setField("user_pwd"));
		}
		
	}
		
	public static class AdminRefRoleCriteria extends SimpleCriteria {
		
		public void setId(Criterion criterion) {
			this.addCriterion(criterion.setField("id"));
		}
		
		public void setAdminid(Criterion criterion) {
			this.addCriterion(criterion.setField("adminid"));
		}
		
		public void setRoleid(Criterion criterion) {
			this.addCriterion(criterion.setField("roleid"));
		}
		
	}
		
	public static class AppLogCriteria extends SimpleCriteria {
		
		public void set主键(Criterion criterion) {
			this.addCriterion(criterion.setField("主键"));
		}
		
		public void set创建时间(Criterion criterion) {
			this.addCriterion(criterion.setField("创建时间"));
		}
		
		public void set操作ip(Criterion criterion) {
			this.addCriterion(criterion.setField("操作ip"));
		}
		
		public void set日志内容(Criterion criterion) {
			this.addCriterion(criterion.setField("日志内容"));
		}
		
		public void set日志类型(Criterion criterion) {
			this.addCriterion(criterion.setField("日志类型"));
		}
		
		public void set用户id(Criterion criterion) {
			this.addCriterion(criterion.setField("用户id"));
		}
		
	}
		
	public static class AppLoginLogCriteria extends SimpleCriteria {
		
		public void setId(Criterion criterion) {
			this.addCriterion(criterion.setField("id"));
		}
		
		public void setLoginIp(Criterion criterion) {
			this.addCriterion(criterion.setField("login_ip"));
		}
		
		public void setLoginTime(Criterion criterion) {
			this.addCriterion(criterion.setField("login_time"));
		}
		
		public void setModels(Criterion criterion) {
			this.addCriterion(criterion.setField("models"));
		}
		
		public void setSystemType(Criterion criterion) {
			this.addCriterion(criterion.setField("system_type"));
		}
		
		public void setSystemVersion(Criterion criterion) {
			this.addCriterion(criterion.setField("system_version"));
		}
		
		public void setUserId(Criterion criterion) {
			this.addCriterion(criterion.setField("user_id"));
		}
		
		public void setVersionCode(Criterion criterion) {
			this.addCriterion(criterion.setField("version_code"));
		}
		
	}
		
	public static class LogrecordCriteria extends SimpleCriteria {
		
		public void setId(Criterion criterion) {
			this.addCriterion(criterion.setField("id"));
		}
		
		public void setContent(Criterion criterion) {
			this.addCriterion(criterion.setField("content"));
		}
		
		public void setIp(Criterion criterion) {
			this.addCriterion(criterion.setField("ip"));
		}
		
		public void setMakeClass(Criterion criterion) {
			this.addCriterion(criterion.setField("make_class"));
		}
		
		public void setMakePeople(Criterion criterion) {
			this.addCriterion(criterion.setField("make_people"));
		}
		
		public void setMakeTime(Criterion criterion) {
			this.addCriterion(criterion.setField("make_time"));
		}
		
		public void setType(Criterion criterion) {
			this.addCriterion(criterion.setField("type"));
		}
		
	}
		
	public static class MateriaTypeCriteria extends SimpleCriteria {
		
		public void setId(Criterion criterion) {
			this.addCriterion(criterion.setField("id"));
		}
		
		public void setName(Criterion criterion) {
			this.addCriterion(criterion.setField("name"));
		}
		
	}
		
	public static class MaterialCriteria extends SimpleCriteria {
		
		public void setId(Criterion criterion) {
			this.addCriterion(criterion.setField("id"));
		}
		
		public void setContent(Criterion criterion) {
			this.addCriterion(criterion.setField("content"));
		}
		
		public void setCreateDate(Criterion criterion) {
			this.addCriterion(criterion.setField("create_date"));
		}
		
		public void setTitle(Criterion criterion) {
			this.addCriterion(criterion.setField("title"));
		}
		
		public void setTypeId(Criterion criterion) {
			this.addCriterion(criterion.setField("type_id"));
		}
		
		public void setUserId(Criterion criterion) {
			this.addCriterion(criterion.setField("user_id"));
		}
		
	}
		
	public static class MaterialImageCriteria extends SimpleCriteria {
		
		public void setId(Criterion criterion) {
			this.addCriterion(criterion.setField("id"));
		}
		
		public void setCreateTime(Criterion criterion) {
			this.addCriterion(criterion.setField("create_time"));
		}
		
		public void setImageKey(Criterion criterion) {
			this.addCriterion(criterion.setField("image_key"));
		}
		
		public void setImageUrl(Criterion criterion) {
			this.addCriterion(criterion.setField("image_url"));
		}
		
		public void setMaterialId(Criterion criterion) {
			this.addCriterion(criterion.setField("material_id"));
		}
		
	}
		
	public static class MenuCriteria extends SimpleCriteria {
		
		public void setId(Criterion criterion) {
			this.addCriterion(criterion.setField("id"));
		}
		
		public void setCreationTime(Criterion criterion) {
			this.addCriterion(criterion.setField("creation_time"));
		}
		
		public void setIsleaf(Criterion criterion) {
			this.addCriterion(criterion.setField("isleaf"));
		}
		
		public void setName(Criterion criterion) {
			this.addCriterion(criterion.setField("name"));
		}
		
		public void setParentId(Criterion criterion) {
			this.addCriterion(criterion.setField("parent_id"));
		}
		
		public void setParentName(Criterion criterion) {
			this.addCriterion(criterion.setField("parent_name"));
		}
		
		public void setUrl(Criterion criterion) {
			this.addCriterion(criterion.setField("url"));
		}
		
	}
		
	public static class RoleCriteria extends SimpleCriteria {
		
		public void setId(Criterion criterion) {
			this.addCriterion(criterion.setField("id"));
		}
		
		public void setCreateTime(Criterion criterion) {
			this.addCriterion(criterion.setField("create_time"));
		}
		
		public void setDescription(Criterion criterion) {
			this.addCriterion(criterion.setField("description"));
		}
		
		public void setRoleName(Criterion criterion) {
			this.addCriterion(criterion.setField("role_name"));
		}
		
		public void setStatus(Criterion criterion) {
			this.addCriterion(criterion.setField("status"));
		}
		
	}
		
	public static class RoleRefMenuCriteria extends SimpleCriteria {
		
		public void setId(Criterion criterion) {
			this.addCriterion(criterion.setField("id"));
		}
		
		public void setMenuId(Criterion criterion) {
			this.addCriterion(criterion.setField("menu_id"));
		}
		
		public void setRoleId(Criterion criterion) {
			this.addCriterion(criterion.setField("role_id"));
		}
		
	}
		
	public static class UserCriteria extends SimpleCriteria {
		
		public void setId(Criterion criterion) {
			this.addCriterion(criterion.setField("id"));
		}
		
		public void setAreaId(Criterion criterion) {
			this.addCriterion(criterion.setField("area_id"));
		}
		
		public void setBonus(Criterion criterion) {
			this.addCriterion(criterion.setField("bonus"));
		}
		
		public void setBonusTotal(Criterion criterion) {
			this.addCriterion(criterion.setField("bonus_total"));
		}
		
		public void setBonusWillArrive(Criterion criterion) {
			this.addCriterion(criterion.setField("bonus_will_arrive"));
		}
		
		public void setCreateTime(Criterion criterion) {
			this.addCriterion(criterion.setField("create_time"));
		}
		
		public void setExtractTotal(Criterion criterion) {
			this.addCriterion(criterion.setField("extract_total"));
		}
		
		public void setGender(Criterion criterion) {
			this.addCriterion(criterion.setField("gender"));
		}
		
		public void setImageKey(Criterion criterion) {
			this.addCriterion(criterion.setField("image_key"));
		}
		
		public void setImageUrl(Criterion criterion) {
			this.addCriterion(criterion.setField("image_url"));
		}
		
		public void setIntroduceCode(Criterion criterion) {
			this.addCriterion(criterion.setField("introduce_code"));
		}
		
		public void setNickName(Criterion criterion) {
			this.addCriterion(criterion.setField("nick_name"));
		}
		
		public void setOpenid(Criterion criterion) {
			this.addCriterion(criterion.setField("openId"));
		}
		
		public void setParentId(Criterion criterion) {
			this.addCriterion(criterion.setField("parent_id"));
		}
		
		public void setPassword(Criterion criterion) {
			this.addCriterion(criterion.setField("password"));
		}
		
		public void setPhone(Criterion criterion) {
			this.addCriterion(criterion.setField("phone"));
		}
		
		public void setQrKey(Criterion criterion) {
			this.addCriterion(criterion.setField("qr_key"));
		}
		
		public void setQrUrl(Criterion criterion) {
			this.addCriterion(criterion.setField("qr_url"));
		}
		
		public void setShopName(Criterion criterion) {
			this.addCriterion(criterion.setField("shop_name"));
		}
		
		public void setState(Criterion criterion) {
			this.addCriterion(criterion.setField("state"));
		}
		
		public void setToken(Criterion criterion) {
			this.addCriterion(criterion.setField("token"));
		}
		
		public void setType(Criterion criterion) {
			this.addCriterion(criterion.setField("type"));
		}
		
		public void setUnionid(Criterion criterion) {
			this.addCriterion(criterion.setField("unionId"));
		}
		
		public void setUserCode(Criterion criterion) {
			this.addCriterion(criterion.setField("user_code"));
		}
		
	}
		
}