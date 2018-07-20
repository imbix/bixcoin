package com.github.lwaytogo.fcoincash.dto;

import com.github.lwaytogo.util.FPUtils;

/**
 * 	查询订单参数
 * @author Lidy
 *
 */
public class FOrderQueryDTO {

	/**
	 *	 交易对
	 */
	private String symbol;
	
	/**
	 * 	订单状态
	 */
	private String states;
	
	/**
	 * 	查询某个页码之前的订单
	 */
	private String before;
	
	/**
	 * 	查询某个页码之后的订单
	 */
	private String after;
	
	/**
	 * 每页的订单数量，默认为 20 条
	 */
	private String limit;
	

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getStates() {
		return states;
	}

	public void setStates(String states) {
		this.states = states;
	}

	public String getBefore() {
		return before;
	}

	public void setBefore(String before) {
		this.before = before;
	}

	public String getAfter() {
		return after;
	}

	public void setAfter(String after) {
		this.after = after;
	}

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}
	
	public String toParamStr() {
		return FPUtils.paramObjToStr(this);
	}
	
	
	
}
