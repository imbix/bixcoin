package com.github.lwaytogo.fcoincash.strategy;

import java.util.List;

/**
 * 	交易策略
 * @author Lidy
 *
 */
public interface FIStrategyService {

	/**
	 * 	按照市场价-买入
	 */
	boolean buyMarket(String symbol);
	
	/**
	 * 	按照市场价-卖出
	 */
	boolean sellMarket(String symbol);
	
	/**
	 * 	清仓
	 */
	boolean sellAll();

	/**
	 * 7日均线突破30日均线
	 */
	List<?> queryMa();
	
	/**
	 * 	判断大盘是涨还是跌-返回哪些是上涨的
	 * 	尤其需要看BTC
	 */
	Boolean queryIndexUp();
	
	
	
	
	
	
}
