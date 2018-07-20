package com.github.lwaytogo.util;

import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;

/**
 * 参数工具类
 * @author Lidy
 *
 */
public class FPUtils {

	/**
	 * 参数-将treemap转换为字符串
	 * 
	 * @param paramMap
	 * @return
	 */
	public static String paramMapToStr(TreeMap<String, Object> paramMap) {
		StringBuffer paramStr = new StringBuffer();
		if (paramMap == null) {
			return null;
		}
		for (Map.Entry<String, Object> entiry : paramMap.entrySet()) {
			String key = entiry.getKey();
			Object value = entiry.getValue();
			paramStr.append("&").append(key).append("=").append(value);
		}
		if (StringUtils.isNotBlank(paramStr.toString())) {
			return paramStr.toString().substring(1).trim();
		}
		return paramStr.toString();
	}
	
	/**
	 * java对象转换成参数字符串
	 * 
	 * @param t
	 * @return
	 */
	public static <T> String paramObjToStr(T t) {
		Map<String,Object> map = FMapUtils.objectToMap(t);
		TreeMap<String, Object> treeMap = FMapUtils.toTreeMap(map);
		return paramMapToStr(treeMap);
	}
	
}
