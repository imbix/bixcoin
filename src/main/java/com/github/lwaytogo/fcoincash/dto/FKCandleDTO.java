package com.github.lwaytogo.fcoincash.dto;

/**
 * K线行情
 * @author Lidy
 *
 */
public class FKCandleDTO {

	private Long id;
	private Long seq;
	
	/**
	 * 开盘价
	 */
	private Double open;
	
	/**
	 * 收盘价
	 */
	private Double close;
	
	/**
	 * 最高价
	 */
	private Double high;
	
	/**
	 * 最低价
	 */
	private Double low;
	
	/**
	 * 数量
	 */
	private Double count;
	
	private Double base_vol;
	
	private Double quote_vol;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public Double getOpen() {
		return open;
	}

	public void setOpen(Double open) {
		this.open = open;
	}

	public Double getClose() {
		return close;
	}

	public void setClose(Double close) {
		this.close = close;
	}

	public Double getHigh() {
		return high;
	}

	public void setHigh(Double high) {
		this.high = high;
	}

	public Double getLow() {
		return low;
	}

	public void setLow(Double low) {
		this.low = low;
	}

	public Double getCount() {
		return count;
	}

	public void setCount(Double count) {
		this.count = count;
	}

	public Double getBase_vol() {
		return base_vol;
	}

	public void setBase_vol(Double base_vol) {
		this.base_vol = base_vol;
	}

	public Double getQuote_vol() {
		return quote_vol;
	}

	public void setQuote_vol(Double quote_vol) {
		this.quote_vol = quote_vol;
	}

	@Override
	public String toString() {
		return "FKCandleDTO [id=" + id + ", seq=" + seq + ", open=" + open + ", close=" + close + ", high=" + high
				+ ", low=" + low + ", count=" + count + ", base_vol=" + base_vol + ", quote_vol=" + quote_vol + "]";
	}



	
}
