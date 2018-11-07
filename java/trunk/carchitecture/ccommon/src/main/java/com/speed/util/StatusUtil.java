package com.speed.util;

/**
 * 
* @Title: StatusUtil.java
* @Package com.speed.util
* @Description: 状态值汇总
* @author chenwenhao 
* @date 2017-1-12 上午9:40:51
 */
public class StatusUtil {
	
	//用户模块
	/**用户状态：未激活【用于企业账户】*/
	public static final int USER_STATE_NOT_ACTIVATE = 0;
	/**用户状态：可用*/
	public static final int USER_STATE_USED = 1;
	/**用户状态：停用*/
	public static final int USER_STATE_STOP = 2;
	/**用户性别：男*/
	public static final int USER_SEX_MAN = 1;
	/**用户性别：女*/
	public static final int USER_SEX_WOMAN = 0;
	/**证件类型：营业执照*/
	public static final int USER_CERTIFICATE_TYPE_LICENSE = 1;
	/**证件类型：个人身份证*/
	public static final int USER_CERTIFICATE_TYPE_IDCARD = 2;
	/**第三方账户类型：QQ*/
	public static final int USER_THIRD_TYPE_QQ = 0;
	/**第三方账户类型：微信*/
	public static final int USER_THIRD_TYPE_WEIXIN = 1;
	/**第三方账户类型：微博*/
	public static final int USER_THIRD_TYPE_WEIBO = 2;
	
	
	
	
	//聊天模块
	/**群类型 ：公开*/
	public static final int CHAT_GROUP_TYPE_PUBLIC = 1;
	/**群类型 ： 私有*/
	public static final int CHAT_GROUP_TYPE_PRIVATE = 2;
	/**允许群成员邀请别人加入群*/
	public static final int CHAT_GROUP_ALLOW_INVITE_YES = 1;
	/**不允许群成员邀请别人加入群，只有管理员才可以加人*/
	public static final int CHAT_GROUP_ALLOW_INVITE_NO = 0;
	/**群状态：有效*/
	public static final int CHAT_GROUP_STATE_YES = 1;
	/**群状态：无效*/
	public static final int CHAT_GROUP_STATE_NO = 0;
	/**开启消息免打扰**/
	public static final int CHAT_DISTURB_YES = 1;
	/**不开启消息免打扰【可接收消息】**/
	public static final int CHAT_DISTURB_NO = 0;
	/**用户在群里的角色：群主*/
	public static final int CHAT_USER_GROUP_ROLE_HOLDER = 0;
	/**用户在群里的角色：管理员*/
	public static final int CHAT_USER_GROUP_ROLE_MANAGER = 1;
	/**用户在群里的角色：成员*/
	public static final int CHAT_USER_GROUP_ROLE_MEMBER = 2;
	/**是否是黑名单用户：是*/
	public static final int CHAT_USER_BLACK_YES = 1;
	/**是否是黑名单用户：否*/
	public static final int CHAT_USER_BLACK_NO = 0;
	
	
	//...other model
	

}
