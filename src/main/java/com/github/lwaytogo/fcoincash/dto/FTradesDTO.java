package com.github.lwaytogo.fcoincash.dto;

/**
 * 交易
 * @author Lidy
 *
 */
public class FTradesDTO {

	private Long id;
	
	private String side;
	
	private Double price;
	
	private Double amount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
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
	
	
	
	
}
