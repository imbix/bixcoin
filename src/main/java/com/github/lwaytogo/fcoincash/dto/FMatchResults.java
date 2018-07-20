package com.github.lwaytogo.fcoincash.dto;

public class FMatchResults {

	private String price;
	private String fill_fees;
	private String filled_amount;
	private String side;
	private String type;
	private String created_at;
	
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getFill_fees() {
		return fill_fees;
	}
	public void setFill_fees(String fill_fees) {
		this.fill_fees = fill_fees;
	}
	public String getFilled_amount() {
		return filled_amount;
	}
	public void setFilled_amount(String filled_amount) {
		this.filled_amount = filled_amount;
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
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	
	
	
	
}
