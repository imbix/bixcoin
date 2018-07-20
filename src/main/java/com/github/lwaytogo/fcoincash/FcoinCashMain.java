package com.github.lwaytogo.fcoincash;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.github.lwaytogo.fcoincash.dto.FAccountsDTO;
import com.github.lwaytogo.fcoincash.dto.FKCandleDTO;
import com.github.lwaytogo.fcoincash.dto.FMatchResults;
import com.github.lwaytogo.fcoincash.dto.FOrderCreateDTO;
import com.github.lwaytogo.fcoincash.dto.FOrderDTO;
import com.github.lwaytogo.fcoincash.dto.FOrderQueryDTO;
import com.github.lwaytogo.fcoincash.dto.FResult;
import com.github.lwaytogo.fcoincash.dto.FSymbolsDTO;
import com.github.lwaytogo.fcoincash.dto.FTickerDTO;
import com.github.lwaytogo.fcoincash.dto.FTradesDTO;
import com.github.lwaytogo.fcoincash.http.FAccUtils;
import com.github.lwaytogo.fcoincash.http.FHttpUtils;
import com.github.lwaytogo.fcoincash.strategy.FIStrategyService;
import com.github.lwaytogo.fcoincash.strategy.FStrategyServiceImpl;
import com.github.lwaytogo.redis.RedisService;
import com.github.lwaytogo.redis.impl.RedisServiceImpl;
import com.github.lwaytogo.util.FEnumUtils;
import com.github.lwaytogo.util.JsonUtils;
import com.github.lwaytogo.util.RedisEnumUtils;
/**
 * 	追涨杀跌
 * @author Lidy
 *
 */
public class FcoinCashMain {
	
	private static Logger logger = Logger.getLogger(FcoinCashMain.class);
	
	
	private static List<FSymbolsDTO> symbolList = null;
	private static List<FSymbolsDTO> usdtSymbolList = null;
	
	private static final String ftusdt = "ftusdt";
	private static RedisService redisService = new RedisServiceImpl();
	
	private static FIStrategyService fService =  new FStrategyServiceImpl();
	
	static {
		initData();
	}
	
	public static void initData() {
		initSymBolList();
		initUsdtSymBolList();
		showUsdtSymBolList();
	}
	
	/**
	 * 初始化交易对
	 */
	public static void initSymBolList() {
		System.out.println("into initSymBolList ... ");
		if(symbolList == null) {
			symbolList = FHttpUtils.getSymbols();
			String jsonStr = redisService.get(RedisEnumUtils.SYMBOL_LIST);
			if(StringUtils.isNotBlank(jsonStr)) {
				symbolList = JsonUtils.strToList(jsonStr, FSymbolsDTO.class);
			}else {
				symbolList = FHttpUtils.getSymbols();
				redisService.set(RedisEnumUtils.SYMBOL_LIST, JsonUtils.listToStr(symbolList));
			}
		}
		System.out.println("out initSymBolList ... ");
	}
	
	/**
	 * 初始化法币交易对
	 */
	public static void initUsdtSymBolList() {
		if(usdtSymbolList == null) {
			usdtSymbolList = new ArrayList<FSymbolsDTO>();
			if(symbolList != null) {
				for(FSymbolsDTO dto:symbolList) {
					if(StringUtils.endsWith(dto.getName(), FEnumUtils.SYMBOLS_USDT)) {
						usdtSymbolList.add(dto);
					}
				}
			}
		}
	}
	
	/**
	 * 初始所有的法币交易
	 */
	public static void showUsdtSymBolList() {
		if(usdtSymbolList != null) {
			System.out.println("---------------所有的法币交易.start-----------------------------------");
			for(FSymbolsDTO dto:usdtSymbolList) {
				System.out.println("dto:" + dto);
			}
			System.out.println("---------------所有的法币交易.end-----------------------------------");
		}
	}
	
	
	
	public static void main(String[] args) {
		
//		testPublic();
		testKey();
//		start();
		
		logger.debug("aaaL");
		
	}
	
	
	/**
	 * 准备数据
	 */
	public static void start() {
		// 判断指数是否在上涨，如果不上涨则直接结束
		boolean indexUp = fService.queryIndexUp();
		System.out.println("indexUp:" + indexUp);
		/*if(!indexUp) {
			return;
		}*/
		
		fService.queryMa();
		
		
		
		
		
		
	}
	
	public static void buy() {
		
	}

	public static void sell() {
		
		
	}
	
	
	
	public static void testPublic() {
		Long f1 = FHttpUtils.getServiceTime();
		System.out.println("serviceTime:" + f1);
		
		List<String> f2 = FHttpUtils.getCurrencies();
		System.out.println("currentcies:" + f2);
		
		List<FSymbolsDTO> f3 = FHttpUtils.getSymbols();
		System.out.println("ddd:" + symbolList);
		for(FSymbolsDTO s:symbolList) {	
			System.out.println("s:" + s);
		}
		
		FHttpUtils.getTicker(ftusdt);
		FTickerDTO ticker = FHttpUtils.getTickerDepth(FEnumUtils.LEVEL_20,ftusdt);
		System.out.println("ticker:" + ticker);
		
		List<FTradesDTO> list22 = FHttpUtils.getTrades(ftusdt);
		System.out.println("list22:" + list22);
		
		List<FKCandleDTO> list33  = FHttpUtils.getKCandle(FEnumUtils.RESOLUTION_D1, ftusdt);
		System.out.println("list33" + list33 );
	}
	
	
	public static void testKey() {
		List<FAccountsDTO> list = FAccUtils.getAccounts();
		System.out.println("list:" + list );
 
		FOrderCreateDTO dto = new FOrderCreateDTO();
		dto.setSymbol(ftusdt);
		dto.setSide("buy");
		dto.setType("limit");
		dto.setPrice(0.00412D);
		dto.setAmount(423D);
		FResult is = FAccUtils.orderCreate(dto);
		System.out.println(is);
		
		FOrderQueryDTO oqDTO = new FOrderQueryDTO();
		oqDTO.setSymbol(ftusdt);
		oqDTO.setStates(FEnumUtils.ORDER_SUBMITTED);
		List<?> list2 = FAccUtils.orderQuery(oqDTO);
		System.out.println("list2:" + list2);
		
		FOrderDTO odto = FAccUtils.orderQueryOne("9d17a03b852e48c0b3920c7412867623");
		if(odto == null) {
			System.out.println("null");
		}
		System.out.println("odto:" + odto);
		
		FResult result44 = FAccUtils.orderCancel("123");
		System.out.println("result44:" + result44);
		
		FMatchResults result55 = FAccUtils.orderMatchResults("123");
		System.out.println("result55:" + result55);
	}

}
