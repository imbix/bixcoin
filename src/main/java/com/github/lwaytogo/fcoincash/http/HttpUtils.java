package com.github.lwaytogo.fcoincash.http;

import java.io.IOException;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * http底层请求类封装
 * 
 * @author Lidy
 *
 */
public class HttpUtils {
	
	
	public static String get(String url) {
		return get(url,null);
	}
	
	
	public static String post(String url,String data) {
		return post(url, data, null);
	}
 
	/**
	 * get请求
	 * @param url
	 * @return
	 */
	public static String get(String url,Map<String,String> headerMap) {
		System.out.println("http.get.url:" + url);
		String result = null;
		try {
			result = GET(url,headerMap);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("http.get.result:" + result);
		return result;
	}
	
	/**
	 * post请求
	 * @param url
	 * @param data
	 * @return
	 */
	public static String post(String url,String data,Map<String,String> headerMap) {
		String result = null;
		System.out.println("http.post.url:" + url);
		System.out.println("http.post.data:" + data);
		try {
			result = POST(url, data,headerMap);
		} catch (Exception e) {
		}
		System.out.println("http.post.result:" + result);
		return result;
	}
	
	
	private static String GET(String url,Map<String,String> headerMap) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			HttpGet httpGet = new HttpGet(url);
			if(headerMap != null) {
				for(Map.Entry<String, String> entry:headerMap.entrySet()) {
					String name = entry.getKey();
					String value = entry.getValue();
					httpGet.addHeader(name, value);
				}
			}
			CloseableHttpResponse response1 = httpclient.execute(httpGet);
			try {
//				System.out.println(response1.getStatusLine());
				HttpEntity entity1 = response1.getEntity();
				return EntityUtils.toString(entity1);
			} finally {
				response1.close();
			}
		} finally {
			httpclient.close();
		}
	}
	
	private static String POST(String url,String data,Map<String,String> headerMap) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			HttpPost httpPost = new HttpPost(url);
			httpPost.addHeader("Content-Type", "application/json;charset=UTF-8");
			if(headerMap != null) {
				for(Map.Entry<String, String> entry:headerMap.entrySet()) {
					String name = entry.getKey();
					String value = entry.getValue();
					httpPost.addHeader(name, value);
				}
			}
			httpPost.setEntity(new StringEntity(data));
			CloseableHttpResponse response2 = httpclient.execute(httpPost);

			try {
//				System.out.println(response2.getStatusLine());
				HttpEntity entity2 = response2.getEntity();
				return EntityUtils.toString(entity2);
			} finally {
				response2.close();
			}
		} finally {
			httpclient.close();
		}

	}

}
