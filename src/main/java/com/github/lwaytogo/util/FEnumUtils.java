package com.github.lwaytogo.util;
/**
 *  枚举工具类
 * @author Lidy
 *
 */
public class FEnumUtils {
	
	/*********************交易对****************************/
	public static final String SYMBOLS_USDT = "usdt";
	public static final String SYMBOLS_ETH = "eth";
	public static final String SYMBOLS_BTC = "btc";
	public static final String SYMBOLS_FT = "ft";
	
	
	/*****************http 请求************************/
	public static final String GET = "GET";
	public static final String POST = "POST";
	public static final String DELETE = "DELETE";
	public static final String PUT = "PUT";
	
	
	/*****************获取最新的深度明细************************/
	public static final String LEVEL_20 = "L20";
	public static final String LEVEL_100 = "L100";
	public static final String LEVEL_FULL = "full";
	
	/*****************获取 Candle 信息************************/
	/* 1分钟 */
	public static final String RESOLUTION_M1 = "M1";
	public static final String RESOLUTION_M3 = "M3";
	public static final String RESOLUTION_M5 = "M5";
	public static final String RESOLUTION_M15 = "M15";
	public static final String RESOLUTION_M30 = "M30";
	/* 1小时 */
	public static final String RESOLUTION_H1 = "H1";
	public static final String RESOLUTION_H4 = "H4";
	public static final String RESOLUTION_H6 = "H6";
	/* 1天 */
	public static final String RESOLUTION_D1 = "D1";
	/* 1周 */
	public static final String RESOLUTION_W1 = "W1";
	/* 1月 */
	public static final String RESOLUTION_MN = "MN";
	
	/*****************订单状态************************/
	/* 已提交 */
	public static final String ORDER_SUBMITTED = "submitted";
	/* 部分成交 */
	public static final String ORDER_PARTIAL_FILLED = "partial_filled";
	/* 部分成交已撤销 */
	public static final String ORDER_PARTIAL_CANCELED = "partial_canceled";
	/* 完全成交 */
	public static final String ORDER_FILLED = "filled";
	/* 已撤销 */
	public static final String ORDER_CANCELED = "canceled";
	/* 撤销已提交 */
	public static final String ORDER_PENDING_CANCEL = "pending_cancel";
	
	
	
	
}
