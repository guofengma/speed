package com.speed.validator;

import com.speed.util.ErrorCode;
import com.speed.util.JsonResult;
import com.speed.util.StringUtil;



public class AdminValidator {
	 /**
	    * 判断账号
	    * @param result
	    * @param passport
	    */
		public static void validatePassport(JsonResult result, String passport) {
			if (StringUtil.isBlank(passport)) {
				result.addErrorCode(ErrorCode.SYS_PARAM_VALUE_ERROR);
			}
		}
		 /**
		  * 判断密码
		  * @param result
		  * @param passwd
		  */
		public static void validatePassWd(JsonResult result, String passwd) {
			if (StringUtil.isBlank(passwd)) {
				result.addErrorCode(ErrorCode.SYS_PARAM_VALUE_ERROR);
			}
		}
		
	
}
