package com.github.lwaytogo.fcoincash.dto;
/**
 * 行情
 * @author Lidy
 *
 */

public class FTickerDTO {

	/**
	 *  买-对应的价格和量
	 */
	private Double[] bids;
	
	/**
	 *  卖-对应价格和量
	 */
	private Double[] asks;
	
	private Long ts;
	
	private Long seq;
	
	private String type;

	
	public Double[] getBids() {
		return bids;
	}

	public void setBids(Double[] bids) {
		this.bids = bids;
	}

	public Double[] getAsks() {
		return asks;
	}

	public void setAsks(Double[] asks) {
		this.asks = asks;
	}

	public Long getTs() {
		return ts;
	}

	public void setTs(Long ts) {
		this.ts = ts;
	}

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
	
}
