package cn.cebest.framework.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author gaopeng@300.cn
 * @version 2018年8月29日 下午1:05:03
 */
public class StringUtility extends StringUtils {

	public static String toString(Object obj) {
		return obj == null ? null : obj.toString();
	}

	public static boolean isBoolean(String str) {
		if ("true".equalsIgnoreCase(str) || "false".equalsIgnoreCase(str)) {
			return true;
		}
		return false;
	}

	public static int indexOfByRegx(String src, Pattern pattern) {
		Matcher matcher = pattern.matcher(src);
		if (matcher.find()) {
			return src.indexOf(matcher.group());
		}
		return -1;
	}

	/**
	 * HTML标签转义方法
	 * 
	 * @param content
	 * @return
	 */
	public static String convertHtml(String content) {
		if (content == null)
			return "";
		String html = content;
		html = StringUtils.replace(html, "'", "&apos;");
		html = StringUtils.replace(html, "\"", "&quot;");
		html = StringUtils.replace(html, "\t", "&nbsp;&nbsp;");// 替换跳格
		// html = StringUtils.replace(html, " ", "&nbsp;");// 替换空格
		html = StringUtils.replace(html, "<", "&lt;");
		html = StringUtils.replace(html, ">", "&gt;");
		return html;
	}

	/**
	 * List转String，以逗号隔开
	 * 
	 * @param stringList
	 * @return
	 */
	public static String listToString(List<Integer> stringList) {
		if (stringList == null) {
			return null;
		}
		StringBuilder result = new StringBuilder();
		boolean flag = false;
		for (Integer o : stringList) {
			if (flag) {
				result.append(",");
			} else {
				flag = true;
			}
			result.append(o.toString());
		}
		return result.toString();
	}

	// 生成四位随机数
	public static String getValidateCode() {
		String code = String.valueOf(Math.round(Math.random() * 10)) + String.valueOf(Math.round(Math.random() * 10)) + String.valueOf(Math.round(Math.random() * 10)) + String.valueOf(Math.round(Math.random() * 10));
		code = code.substring(0, 4);
		return code;
	}

}
