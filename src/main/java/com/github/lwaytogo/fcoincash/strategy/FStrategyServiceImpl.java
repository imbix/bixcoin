package com.github.lwaytogo.fcoincash.strategy;

import java.util.List;

import com.github.lwaytogo.fcoincash.dto.FKCandleDTO;
import com.github.lwaytogo.fcoincash.dto.FTickerDetailDTO;
import com.github.lwaytogo.fcoincash.http.FAccUtils;
import com.github.lwaytogo.fcoincash.http.FHttpUtils;
import com.github.lwaytogo.util.FConfigUtils;
import com.github.lwaytogo.util.FEnumUtils;
import com.github.lwaytogo.util.FLogUtils;

/**
 * 	策略交易实现
 * @author Lidy
 *
 */
public class FStrategyServiceImpl implements FIStrategyService {
	
	@Override
	public boolean buyMarket(String symbol) {
		return false;
	}

	@Override
	public boolean sellMarket(String symbol) {
		return false;
	}

	@Override
	public boolean sellAll() {
		return false;
	}

	@Override
	public List<?> queryMa() {
		// 判断日K线，6小时K线，30分钟K线，15分钟K线，5分钟K线
		List<FKCandleDTO> list = FHttpUtils.getKCandle(FEnumUtils.RESOLUTION_D1, "btcusdt");
		System.out.println(list);
		
		
		return null;
	}

	@Override
	public Boolean queryIndexUp() {
		// 获取btc等重要的币种交易对
		List<String> symbolList = FConfigUtils.getBtcImport();
		System.out.println("symbolList:" + symbolList);
		for(String symbol:symbolList) {
			FTickerDetailDTO tickerDetail = FHttpUtils.getTicker(symbol);
			System.out.println("tickerDetail." + symbol + ":" + tickerDetail);
			System.out.println(symbol +".isUp:" + tickerDetail.isUp() + " " +tickerDetail.isUpPercent() + "%" );
			if(tickerDetail.isDown()) {
				FLogUtils.info(FLogUtils.STATUS_LOG, symbol, " 下跌:" + tickerDetail.isUpPercent() + "%,不推荐现在操作，退出!");
				System.out.println("...大盘在跌，不建议操作，交易结束！");
				return false;
			}
		}
		return true;
	}

}
