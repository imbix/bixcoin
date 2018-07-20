package com.github.lwaytogo.util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.lwaytogo.fcoincash.dto.FSymbolsDTO;

public class JsonUtils {

	/**
	  *  将json转换成list
	 * @param jsonStr 
	 * @param clazz String.class
	 * @return List<String>
	 */
	public static <T> List<T> getDataList(String jsonStr,Class<T> clazz) {
		JSONObject jsonObject = JSONObject.parseObject(jsonStr);
		return JSON.parseArray(jsonObject.getString("data"), clazz);
	}
	
	/**
	 * 获取data的json对象
	 */
	public static JSONObject getDataJsonObject(String jsonStr) {
		JSONObject jsonObject = JSONObject.parseObject(jsonStr);
		return jsonObject.getJSONObject("data");
	}
	
	/**
	 * 	获取data对象
	 */
	public static <T> T getDataObject(String jsonStr,Class<T> clazz) {
		JSONObject jsonObject = JSONObject.parseObject(jsonStr);
		if(!"0".equals(jsonObject.getString("status"))) {
			return null;
		}
		return JSONObject.parseObject(jsonStr, clazz);
	}
	
	/**
	 * 获取data字符串
	 */
	public static String getDataStr(String jsonStr) {
		JSONObject jsonObject = JSONObject.parseObject(jsonStr);
		return jsonObject.getString("data");
	}
	
	/**
	 * 	将map转换为json对象
	 * @param map
	 * @return
	 */
	public static String mapToJsonStr(Map<String,String> map) {
		return JSON.toJSONString(map);
	}
	
	/**
	 *  字符串转对象
	 */
	public static <T> List<T> strToList(String jsonStr,Class<T> clazz) {
		return JSON.parseArray(jsonStr, clazz);
	}
	
	/**
	 * 对象转字符串
	 */
	public static String listToStr(List<FSymbolsDTO> symbolList) {
		return JSONArray.toJSONString(symbolList);
	}
	
	/**
	 *   将json 转换成Java对象
	 */
	public static <T> T toJava(String jsonStr,Class<T> clazz) {
		JSONObject jsonObject = JSONObject.parseObject(jsonStr);
		return JSON.parseObject(jsonObject.getString("data"), clazz);
	}
	
	/**
	 * 对象转json字符串
	 * @param t
	 * @return
	 */
	public static <T> String objToStr(T t) {
		return JSONObject.toJSONString(t);
	}
	
	
	public static void main(String[] args) {
		
		test(new BigDecimal(4000));
		
	}
	
	private static long i = 1;
	private static BigDecimal cashMonth = new BigDecimal(4000);
	
	
	public static void test(BigDecimal money) {
		if(i == 12 * 10) {
			System.out.println("最终结果:" + money);
			return ;
		}
		BigDecimal cash = money.multiply(new BigDecimal("0.1"), MathContext.DECIMAL32).divide(new BigDecimal("12"), MathContext.DECIMAL32);
		money = money.add(cash).add(cashMonth);
		System.out.println("" + i/12 + "年  第" + i + "个月	 本金:" + money + " 本月利息:" + cash);
		i ++ ;
		test(money);
	}
	
	
}
