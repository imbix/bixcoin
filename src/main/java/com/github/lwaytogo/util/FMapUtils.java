package com.github.lwaytogo.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class FMapUtils {

	/**
	 * 将map转换为treemap treemap默认是排序的
	 */
	public static TreeMap<String, Object> toTreeMap(Map<String, Object> map) {
		TreeMap<String, Object> treeMap = new TreeMap<String, Object>();
		if (map == null) {
			return null;
		}
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			String key = (String) entry.getKey();
			Object value = entry.getValue();
			if(value != null) {
				treeMap.put(key, value);
			}
		}
		return treeMap;
	}

	/**
	 * 	map 转 对象 
	 * @param map
	 * @param beanClass
	 * @return
	 * @throws Exception
	 */
	public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) {
		if (map == null) {
			return null;
		}

		Object obj = null;
		try {
			obj = beanClass.newInstance();
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor property : propertyDescriptors) {
				Method setter = property.getWriteMethod();
				if (setter != null) {
					setter.invoke(obj, map.get(property.getName()));
				}
			}
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		return obj;
	}

	/**
	 * 	对象转map
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> objectToMap(Object obj) {
		if (obj == null) {
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		BeanInfo beanInfo = null;
		try {
			beanInfo = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor property : propertyDescriptors) {
				String key = property.getName();
				if (key.compareToIgnoreCase("class") == 0) {
					continue;
				}
				Method getter = property.getReadMethod();
				Object value = getter != null ? getter.invoke(obj) : null;
				map.put(key, value);
			}
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		return map;
	}

	public static void main(String[] args) {

		
		
	}

}
