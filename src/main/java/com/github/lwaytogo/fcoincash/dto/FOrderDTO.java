package com.github.lwaytogo.fcoincash.dto;

/**
 * 订单
 * @author Lidy
 *
 */
public class FOrderDTO {

	/**
	 * 订单ID
	 */
	private String id;
	
	/**
	 * 交易对
	 */
	private String symbol;
	
	/**
	 * 交易方向（buy,sell）
	 */
	private String side;
	
	/**
	 * 订单类型（limit,market）
	 */
	private String type;
	
	/**
	 * 下单价格
	 */
	private String price;
	
	/**
	 * 下单数量 
	 */
	private String amount;
	
	/**
	 * 订单状态
	 * submitted 	已提交
	 * partial_filled 	部分成交
	 * partial_canceled 	部分成交已撤销
	 * filled 	完全成交
	 * canceled 	已撤销
	 * pending_cancel 	撤销已提交
	 */
	private String state;
	
	/**
	 * 已成交
	 */
	private String executed_value;
	
	/**
	 * 成交量
	 */
	private String filled_amount;
	
	/**
	 * 手续费
	 */
	private String fill_fees;
	
	/**
	 * 创建时间
	 */
	private Long created_at;
	
	/**
	 * 来源
	 */
	private String source;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getExecuted_value() {
		return executed_value;
	}

	public void setExecuted_value(String executed_value) {
		this.executed_value = executed_value;
	}

	public String getFilled_amount() {
		return filled_amount;
	}

	public void setFilled_amount(String filled_amount) {
		this.filled_amount = filled_amount;
	}

	public String getFill_fees() {
		return fill_fees;
	}

	public void setFill_fees(String fill_fees) {
		this.fill_fees = fill_fees;
	}

	public Long getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Long created_at) {
		this.created_at = created_at;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Override
	public String toString() {
		return "FOrderDTO [id=" + id + ", symbol=" + symbol + ", side=" + side + ", type=" + type + ", price=" + price
		        + ", amount=" + amount + ", state=" + state + ", executed_value=" + executed_value + ", filled_amount="
		        + filled_amount + ", fill_fees=" + fill_fees + ", created_at=" + created_at + ", source=" + source
		        + "]";
	}
	
	
	
	
	
	
	
	
}
