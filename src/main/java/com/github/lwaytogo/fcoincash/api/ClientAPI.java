package com.github.lwaytogo.fcoincash.api;

public interface ClientAPI {

	public static String URL = "https://api.fcoin.com/v2/";
	
	/**
	 * 查询服务器时间
	 */
	public static String URL_GET_SERVICE_TIME = URL + "public/server-time";
	
	/**
	 * 查询可用币种
	 */
	public static String URL_GET_CURRENCIES = URL + "public/currencies";
	
	/**
	 * 查询可用交易对
	 */
	public static String URL_GET_SYMBOLS = URL + "public/symbols";
	
	/**
	 * 获取ticker数据
	 */
	public static String URL_GET_TICKER = URL + "market/ticker/$symbol";
	
	/**
	 * 获取最新的深度明细
	 */
	public static String URL_GET_DEPTH = URL + "market/depth/$level/$symbol";
	
	/**
	 * 获取最新的成交明细
	 */
	public static String URL_GET_TRADES = URL + "market/trades/$symbol";
	
	/**
	 * 获取Candle 信息-K线
	 */
	public static String URL_GET_CANDLE = URL + "market/candles/$resolution/$symbol";
	
	/**
	 * 查询账户资产
	 */
	public static String URL_GET_ACCOUNTS = URL + "accounts/balance";
	
	/**
	 * 创建新的订单
	 */
	public static String URL_POST_ORDERS = URL + "orders";
	
	/**
	 * 查询订单列表
	 */
	public static String URL_GET_ORDERS = URL + "orders";
	
	/**
	 * 获取指定订单
	 */
	public static String URL_GET_ORDERS_ONE = URL + "orders/{order_id}";
	
	/**
	 * 申请撤销订单
	 */
	public static String URL_POST_ORDERS_SUBMIT_CANCEL = URL + "orders/{order_id}/submit-cancel";
	
	/**
	 * 查询指定订单的成交记录
	 */
	public static String URL_GET_ORDERS_MATCH_RESULTS = URL + "orders/{order_id}/match-results";
	
	
	
	
}
