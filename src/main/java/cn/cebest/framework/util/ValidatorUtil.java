package cn.cebest.framework.util;

import java.util.regex.Pattern;
import cn.cebest.framework.constant.Constants;

/**
 *  验证工具类
  * @author maming  
  * @date 2018年8月29日
 */
public class ValidatorUtil {

	/**
	* 校验IP地址
	* 
	* @param ipAddr
	* @return
	*/
	public static boolean isMobile(String mobile) {
		return Pattern.matches(Constants.REGEX_PHONE, mobile);
	}
	
	
	/**
	* 校验邮箱
	* 
	* @param email
	* @return 校验通过返回true，否则返回false
	*/
	public static boolean isEmail(String email) {
	return Pattern.matches(Constants.REGEX_EMAIL, email);
	}

	/**
	* 校验汉字
	* 
	* @param chinese
	* @return 校验通过返回true，否则返回false
	*/
	public static boolean isChinese(String chinese) {
	return Pattern.matches(Constants.REGEX_CHINESE, chinese);
	}

	/**
	* 校验身份证
	* 
	* @param idCard
	* @return 校验通过返回true，否则返回false
	*/
	public static boolean isIDCard(String idCard) {
	return Pattern.matches(Constants.REGEX_ID_CARD, idCard);
	}

	/**
	* 校验URL
	* 
	* @param url
	* @return 校验通过返回true，否则返回false
	*/
	public static boolean isUrl(String url) {
	return Pattern.matches(Constants.REGEX_URL, url);
	}

	/**
	* 校验IP地址
	* 
	* @param ipAddr
	* @return
	*/
	public static boolean isIPAddr(String ipAddr) {
	return Pattern.matches(Constants.REGEX_IP_ADDR, ipAddr);
	}

}
