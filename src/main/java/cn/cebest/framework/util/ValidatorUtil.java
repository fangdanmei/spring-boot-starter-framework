package cn.cebest.framework.util;

import org.apache.commons.lang3.StringUtils;
import cn.cebest.framework.constant.Constants;

/**
 *  验证工具类
  * @author maming  
  * @date 2018年8月29日
 */
public class ValidatorUtil {

	public static boolean isMobile(String mobile) {
		
		if (StringUtils.isEmpty(mobile)) {
			return false;
		}

		if (!mobile.matches(Constants.PHONE_PATTERN)) {
			return false;
		}

		return true;
	}

}
