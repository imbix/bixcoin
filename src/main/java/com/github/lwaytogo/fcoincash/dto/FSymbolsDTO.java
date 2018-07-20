package com.github.lwaytogo.fcoincash.dto;
/**
 * 交易对
 * @author Lidy
 *
 */
public class FSymbolsDTO {
	
	private String name;
	
	/**
	 * 表示基准货币成交量, 如 btcusdt 中 btc 的量.
	 */
	private String base_currency;
	
	/**
	 *  表示计价货币成交量, 如 btcusdt 中 usdt 的量
	 */
	private String quote_currency;
	
	private String price_decimal;
	
	private String amount_decimal;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBase_currency() {
		return base_currency;
	}

	public void setBase_currency(String base_currency) {
		this.base_currency = base_currency;
	}

	public String getQuote_currency() {
		return quote_currency;
	}

	public void setQuote_currency(String quote_currency) {
		this.quote_currency = quote_currency;
	}

	public String getPrice_decimal() {
		return price_decimal;
	}

	public void setPrice_decimal(String price_decimal) {
		this.price_decimal = price_decimal;
	}

	public String getAmount_decimal() {
		return amount_decimal;
	}

	public void setAmount_decimal(String amount_decimal) {
		this.amount_decimal = amount_decimal;
	}

	@Override
	public String toString() {
		return "FSymbols [name=" + name + ", base_currency=" + base_currency + ", quote_currency=" + quote_currency
				+ ", price_decimal=" + price_decimal + ", amount_decimal=" + amount_decimal + "]";
	}
	
	
	

}
