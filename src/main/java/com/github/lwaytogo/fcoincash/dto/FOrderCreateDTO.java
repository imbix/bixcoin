package com.github.lwaytogo.fcoincash.dto;
/**
 * 	创建新订单
 * @author Lidy
 *
 */

import com.github.lwaytogo.util.FPUtils;

public class FOrderCreateDTO {

	/**
	 * 	交易对
	 */
	private String symbol;
	
	/**
	 * 	交易方向
	 */
	private String side;
	
	/**
	 * 	订单类型
	 */
	private String type;
	
	/**
	 * 	价格
	 */
	private Double price;
	
	/**
	 * 下单量
	 */
	private Double amount;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * 	将对象转换成参数字符串
	 * @return
	 */
	public String toParamStr() {
		return FPUtils.paramObjToStr(this);
	}
	
	
	
}
