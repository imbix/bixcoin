package com.github.lwaytogo.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 * 记录log
 * 可以记录到redis中，然后每天定时跑一下
 * @author Lidy
 *
 */
public class FLogUtils {

	private static final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	
	private static File file = new File(FConfigUtils.getLogFilePath()  + "abc.log");
	
	public static final String STATUS_LOG = "log";
	public static final String STATUS_BUY = "buy";
	public static final String STATUS_SELL = "sell";
	
	
	
	
	public static void main(String[] args) {
		
		
//		FLogUtils.info("log" ,"btcusdt", "下跌:-0.71%,不推荐现在操作，退出!");
		
	}
	
	static {
		fileCreate(file);
	}
	
	/**
	 * 买
	 */
	public static void infoBuy(String symbol) {
		
	}

	/**
	 * 卖
	 */
	public static void infoSell(String symbol) {
		
		
	}

	/**
	 * 添加log
	 */
	public static void info(String status,String symbol,String msg) {
		logWrite(status + "-" + getDateTime() + " : " + symbol + " msg:" + msg);
	}
	
	/**
	 * log 写入文件
	 * @param lines
	 */
	private static void logWrite(String line) {
		System.out.println("写入log文件:" + line);
		List<String> lines = new ArrayList<String>();
		lines.add(line);
		try {
			FileUtils.writeLines(file, lines, true);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("写入log.info失败!");
		}
		
	}
	
	
	public static String getDateTime() {
		return df.format(new Date());
	}
	
	
	private static void fileCreate(File file) {
		if(file != null) {
			if(!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("创建 file log 文件失败!");
				}
			}
		}
	}
	
	
	
	
}
