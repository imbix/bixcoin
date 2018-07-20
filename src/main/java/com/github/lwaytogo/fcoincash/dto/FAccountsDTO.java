package com.github.lwaytogo.fcoincash.dto;
/**
 * 	账户信息
 * @author Lidy
 *
 */
public class FAccountsDTO {

	/**
	 * 	货币
	 */
	private String currency;
	
	/**
	 * 	可用
	 */
	private Double available;
	
	/**
	 * 	冻结
	 */
	private Double frozen;
	
	
	private Double balance;


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public Double getAvailable() {
		return available;
	}


	public void setAvailable(Double available) {
		this.available = available;
	}


	public Double getFrozen() {
		return frozen;
	}


	public void setFrozen(Double frozen) {
		this.frozen = frozen;
	}


	public Double getBalance() {
		return balance;
	}


	public void setBalance(Double balance) {
		this.balance = balance;
	}


	@Override
	public String toString() {
		return "FAccountsDTO [currency=" + currency + ", available=" + available + ", frozen=" + frozen + ", balance="
		        + balance + "]";
	}
	
	
	
	
	
}
