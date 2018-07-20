package com.github.lwaytogo.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

/**
 * 读取配置文件
 * 
 * @author Lidy
 *
 */
public class FConfigUtils {

	private static Properties sysConfig = new Properties();

	static { // 读取配置文件
		InputStream inputStream = FConfigUtils.class.getResourceAsStream("/fcoin_config.properties");
		try {
			if (inputStream != null) {
				sysConfig.load(inputStream);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static String getProperty(String key) {
		return sysConfig.getProperty(key);
	}

	public static void setProperty(String key, String value) {
		sysConfig.setProperty(key, value);
	}

	public static String getKey() {
		return getProperty("fcoin_key");
	}

	public static String getSecret() {
		return getProperty("fcoin_secret");
	}

	/**
	 * 获取log文件记录
	 * @return
	 */
	public static String getLogFilePath() {
		return getProperty("fcoin_log_path");
	}
	
	/**
	 * 获取指数相关币种
	 */
	public static List<String> getBtcImport() {
		List<String> list = new ArrayList<String>();
		String btcImportStr = getProperty("fcoin_import_btc");
		String[] sss = StringUtils.split(btcImportStr, ",");
		for(int i=0;i<sss.length;i++) {
			list.add(sss[i]);
		}
		return list;
	}
	
}
