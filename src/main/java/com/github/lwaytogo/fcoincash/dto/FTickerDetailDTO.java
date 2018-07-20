package com.github.lwaytogo.fcoincash.dto;

import java.math.BigDecimal;
import java.util.List;

/**
 * 单个币种行情
 * @author Lidy
 *
 */
public class FTickerDetailDTO {
	
	
	public FTickerDetailDTO() {
		
	}
	
	public FTickerDetailDTO(List<Double> list) {
		if(list != null && list.size() >0) {
			for(int i=0;i<list.size();i++) {
				this.setPriceNow(list.get(0));
				this.setVolNow(list.get(1));
				this.setMaxPrice(list.get(2));
				this.setMaxVol(list.get(3));
				this.setMinPrice(list.get(4));
				this.setMinVol(list.get(5));
				this.setPriceOpen(list.get(6));
				this.setPriceHigh(list.get(7));
				this.setPriceLow(list.get(8));
				this.setVolBtc(list.get(9));
				this.setVolUsdt(list.get(10));
			}
		}
	}
	
	/**
	 * 是否上涨
	 */
	public Boolean isUp() {
		if(this.getPriceNow() - this.getPriceOpen() > 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 上涨百分比
	 */
	public Double isUpPercent() {
		Double p = ( ( this.getPriceNow() - this.getPriceOpen() )/this.getPriceOpen() ) *100;
		BigDecimal pp = new BigDecimal(p).setScale(2, BigDecimal.ROUND_HALF_UP);
		return pp.doubleValue();
	}
	
	/**
	 * 是否下跌
	 */
	public Boolean isDown() {
		return !(isUp());
	}
	
	
	public FTickerDetailDTO(Double[] dd) {
		if(dd != null && dd.length>0) {
			this.setPriceNow(dd[0]);
			this.setVolNow(dd[1]);
			this.setMaxPrice(dd[2]);
			this.setMaxVol(dd[3]);
			this.setMinPrice(dd[4]);
			this.setMinVol(dd[5]);
			this.setPriceOpen(dd[6]);
			this.setPriceHigh(dd[7]);
			this.setPriceLow(dd[8]);
			this.setVolBtc(dd[9]);
			this.setVolUsdt(dd[10]);
		}
	}
	

	/**
	 * "最新成交价"
	 */
	private Double priceNow;
	
	/**
	 * "最近一笔成交的成交量"
	 */
	private Double volNow;
	
	/**
	 * "最大买一价"
	 */
	private Double maxPrice;
	
	/**
	 * "最大买一量"
	 */
	private Double maxVol;
	
	/**
	 * "最小卖一价",
	 */
	private Double minPrice;
	
	/**
	 * "最小卖一量",
	 */
	private Double minVol;
	  
	/**
	 * "24小时前成交价",
	 */
	private Double priceOpen;
	
	/**
	 * "24小时内最高价",
	 */
	private Double priceHigh;
	
	/**
	 * "24小时内最低价",
	 */
	private Double priceLow;
	
	/**
	 * "24小时内基准货币成交量, 如 btcusdt 中 btc 的量",
	 */
	private Double volBtc;

	/**
	 *  "24小时内计价货币成交量, 如 btcusdt 中 usdt 的量"
	 */
	private Double volUsdt;

	public Double getPriceNow() {
		return priceNow;
	}

	public void setPriceNow(Double priceNow) {
		this.priceNow = priceNow;
	}

	public Double getVolNow() {
		return volNow;
	}

	public void setVolNow(Double volNow) {
		this.volNow = volNow;
	}

	public Double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}

	public Double getMaxVol() {
		return maxVol;
	}

	public void setMaxVol(Double maxVol) {
		this.maxVol = maxVol;
	}

	public Double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}

	public Double getMinVol() {
		return minVol;
	}

	public void setMinVol(Double minVol) {
		this.minVol = minVol;
	}

	public Double getPriceOpen() {
		return priceOpen;
	}

	public void setPriceOpen(Double priceOpen) {
		this.priceOpen = priceOpen;
	}

	public Double getPriceHigh() {
		return priceHigh;
	}

	public void setPriceHigh(Double priceHigh) {
		this.priceHigh = priceHigh;
	}

	public Double getPriceLow() {
		return priceLow;
	}

	public void setPriceLow(Double priceLow) {
		this.priceLow = priceLow;
	}

	public Double getVolBtc() {
		return volBtc;
	}

	public void setVolBtc(Double volBtc) {
		this.volBtc = volBtc;
	}

	public Double getVolUsdt() {
		return volUsdt;
	}

	public void setVolUsdt(Double volUsdt) {
		this.volUsdt = volUsdt;
	}
	

	@Override
	public String toString() {
		return "FTickerDetailDTO [priceNow=" + priceNow + ", volNow=" + volNow + ", maxPrice=" + maxPrice + ", maxVol="
				+ maxVol + ", minPrice=" + minPrice + ", minVol=" + minVol + ", priceOpen=" + priceOpen + ", priceHigh="
				+ priceHigh + ", priceLow=" + priceLow + ", volBtc=" + volBtc + ", volUsdt=" + volUsdt + "]";
	}
	  
	  
	  
	  
	  
	 
	
	
}
