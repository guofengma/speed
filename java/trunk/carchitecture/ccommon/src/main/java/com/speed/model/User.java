package com.speed.model;

public class User implements Entity {
	
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	protected Integer id;
	
	/**  */
	protected Integer bonus;
	
	/**  */
	protected Integer bonusTotal;
	
	/**  */
	protected Integer bonusWillArrive;
	
	/** 创建时间 */
	protected String createTime;
	
	/**  */
	protected Integer extractTotal;
	
	/** 性别 */
	protected String gender;
	
	/** 头像key */
	protected String imageKey;
	
	/** 头像url */
	protected String imageUrl;
	
	/** 推荐码 */
	protected String introduceCode;
	
	/** 昵称 */
	protected String nickName;
	
	/** 微信登录使用openId */
	protected String openid;
	
	/** 父级id */
	protected Integer parentId;
	
	/** 密码 */
	protected String password;
	
	/** 手机号码 */
	protected String phone;
	
	/** 店铺二维码key */
	protected String qrKey;
	
	/** 店铺二维码url */
	protected String qrUrl;
	
	/** 店铺名称 */
	protected String shopName;
	
	/** 状态(1=启用，2=停用，默认启用) */
	protected Integer state;
	
	/** token标识 */
	protected String token;
	
	/** 用户身份 */
	protected Integer type;
	
	/** 微信登录使用unionId */
	protected String unionid;
	
	/** 用户标识 */
	protected Integer userCode;
	
	/**  */
	protected Integer areaId;
	
 	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getBonus() {
		return bonus;
	}
	
	public void setBonus(Integer bonus) {
		this.bonus = bonus;
	}
	
	public Integer getBonusTotal() {
		return bonusTotal;
	}
	
	public void setBonusTotal(Integer bonusTotal) {
		this.bonusTotal = bonusTotal;
	}
	
	public Integer getBonusWillArrive() {
		return bonusWillArrive;
	}
	
	public void setBonusWillArrive(Integer bonusWillArrive) {
		this.bonusWillArrive = bonusWillArrive;
	}
	
	public String getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	public Integer getExtractTotal() {
		return extractTotal;
	}
	
	public void setExtractTotal(Integer extractTotal) {
		this.extractTotal = extractTotal;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getImageKey() {
		return imageKey;
	}
	
	public void setImageKey(String imageKey) {
		this.imageKey = imageKey;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public String getIntroduceCode() {
		return introduceCode;
	}
	
	public void setIntroduceCode(String introduceCode) {
		this.introduceCode = introduceCode;
	}
	
	public String getNickName() {
		return nickName;
	}
	
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	public String getOpenid() {
		return openid;
	}
	
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	public Integer getParentId() {
		return parentId;
	}
	
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getQrKey() {
		return qrKey;
	}
	
	public void setQrKey(String qrKey) {
		this.qrKey = qrKey;
	}
	
	public String getQrUrl() {
		return qrUrl;
	}
	
	public void setQrUrl(String qrUrl) {
		this.qrUrl = qrUrl;
	}
	
	public String getShopName() {
		return shopName;
	}
	
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	
	public Integer getState() {
		return state;
	}
	
	public void setState(Integer state) {
		this.state = state;
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
	public Integer getType() {
		return type;
	}
	
	public void setType(Integer type) {
		this.type = type;
	}
	
	public String getUnionid() {
		return unionid;
	}
	
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	
	public Integer getUserCode() {
		return userCode;
	}
	
	public void setUserCode(Integer userCode) {
		this.userCode = userCode;
	}
	
	public Integer getAreaId() {
		return areaId;
	}
	
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	
 	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("id = ").append(id).append(", ");
		builder.append("bonus = ").append(bonus).append(", ");
		builder.append("bonusTotal = ").append(bonusTotal).append(", ");
		builder.append("bonusWillArrive = ").append(bonusWillArrive).append(", ");
		builder.append("createTime = ").append(createTime).append(", ");
		builder.append("extractTotal = ").append(extractTotal).append(", ");
		builder.append("gender = ").append(gender).append(", ");
		builder.append("imageKey = ").append(imageKey).append(", ");
		builder.append("imageUrl = ").append(imageUrl).append(", ");
		builder.append("introduceCode = ").append(introduceCode).append(", ");
		builder.append("nickName = ").append(nickName).append(", ");
		builder.append("openid = ").append(openid).append(", ");
		builder.append("parentId = ").append(parentId).append(", ");
		builder.append("password = ").append(password).append(", ");
		builder.append("phone = ").append(phone).append(", ");
		builder.append("qrKey = ").append(qrKey).append(", ");
		builder.append("qrUrl = ").append(qrUrl).append(", ");
		builder.append("shopName = ").append(shopName).append(", ");
		builder.append("state = ").append(state).append(", ");
		builder.append("token = ").append(token).append(", ");
		builder.append("type = ").append(type).append(", ");
		builder.append("unionid = ").append(unionid).append(", ");
		builder.append("userCode = ").append(userCode).append(", ");
		builder.append("areaId = ").append(areaId);
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
		User other = (User) obj;
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