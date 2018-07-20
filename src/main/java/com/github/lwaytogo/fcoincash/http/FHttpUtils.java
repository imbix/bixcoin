package com.github.lwaytogo.fcoincash.http;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.lwaytogo.fcoincash.api.ClientAPI;
import com.github.lwaytogo.fcoincash.dto.FKCandleDTO;
import com.github.lwaytogo.fcoincash.dto.FSymbolsDTO;
import com.github.lwaytogo.fcoincash.dto.FTickerDTO;
import com.github.lwaytogo.fcoincash.dto.FTickerDetailDTO;
import com.github.lwaytogo.fcoincash.dto.FTradesDTO;
import com.github.lwaytogo.util.FConfigUtils;
import com.github.lwaytogo.util.FEnumUtils;
import com.github.lwaytogo.util.JsonUtils;

/**
 * get和post请求
 * 
 * @author Lidy
 *
 */
public class FHttpUtils extends HttpUtils implements ClientAPI {
	
	/**
	 * 封装get请求-包含签名
	 */
	public static String getSign(String url) {
		Long timestamp = System.currentTimeMillis();
		String signStr = sign(FEnumUtils.GET, url, timestamp, "");
		Map<String, String> headerMap = getHttpHeader(timestamp, signStr);
		return get(url, headerMap);
	}

	/**
	 * 封装post请求-包含签名
	 */
	public static String postSign(String url, String dataUrl, String dataJson) {
		Long timestamp = System.currentTimeMillis();
		String signStr = sign(FEnumUtils.POST, url, timestamp, dataUrl);
		Map<String, String> headerMap = getHttpHeader(timestamp, signStr);
		return post(url, dataJson, headerMap);
	}

	/**
	 * 获取http请求头
	 * 
	 * @param signStr
	 * @return
	 */
	private static Map<String, String> getHttpHeader(Long timestamp, String signStr) {
		Map<String, String> httpHeaderMap = new HashMap<>();
		System.out.println("--------------------------http.header.start-------------------------------");
		httpHeaderMap.put("FC-ACCESS-KEY", FConfigUtils.getKey());
		httpHeaderMap.put("FC-ACCESS-SIGNATURE", signStr);
		httpHeaderMap.put("FC-ACCESS-TIMESTAMP", timestamp + "");

		System.out.println("FC-ACCESS-KEY:" + FConfigUtils.getKey());
		System.out.println("FC-ACCESS-SIGNATURE:" + signStr);
		System.out.println("FC-ACCESS-TIMESTAMP:" + timestamp);

		System.out.println("--------------------------http.header.start-------------------------------");
		return httpHeaderMap;
	}

	/**
	 * api 签名
	 * 
	 * @param httpMethod
	 * @param httpRequestUri
	 * @param timestamp
	 * @param postBody
	 * @return
	 */
	private static String sign(String httpMethod, String httpRequestUri, Long timestamp, String postBody) {
		String signData = httpMethod + httpRequestUri + timestamp + postBody;
		System.out.println("sign.data=[HTTP_METHOD + HTTP_REQUEST_URI + TIMESTAMP + POST_BODY]");
		System.out.println("sign.data=[" + httpMethod +" + " + httpRequestUri + " + " + timestamp + " + " + postBody + "]");
		byte[] signDataBase64 = null;
		try {
			signDataBase64 = Base64.encodeBase64(signData.getBytes("UTF-8"));
			byte[] macSha1Data = HmacUtils.hmacSha1(FConfigUtils.getSecret().getBytes("UTF-8"), signDataBase64);
			byte[] resultData = Base64.encodeBase64(macSha1Data);
			return new String(resultData, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			System.out.println("sign error !");
		}
		return null;
	}

	

	/**
	 * 公共接口：查询服务器时间
	 */
	public static Long getServiceTime() {
		return JsonUtils.toJava(get(URL_GET_SERVICE_TIME), Long.class);
	}

	/**
	 * 查询可用币种
	 * [btc, eth, bch, ltc, usdt, ft_frozen, ft, zip, etc, zil, omg, icx, btm, ae, zrx, xrp, bnb, gtc, fi]
	 */
	public static List<String> getCurrencies() {
		return JsonUtils.getDataList(get(URL_GET_CURRENCIES), String.class);
	}

	/**
	 * 查询可用交易对
	 */
	public static List<FSymbolsDTO> getSymbols() {
		return JsonUtils.getDataList(get(URL_GET_SYMBOLS), FSymbolsDTO.class);
	}

	/**
	 * 获取 ticker行情 数据
	 * 
	 * 6348.98, 0.2928, 6348.98, 4.2213, 6361.48, 0.0016, 6384.79, 6442.2, 6291.69, 9148.311870159, 5.823291699546487E7
	 */
	public static FTickerDetailDTO getTicker(String symbol) {
		String url = StringUtils.replace(URL_GET_TICKER, "$symbol", symbol);
		JSONObject dataObject = JsonUtils.getDataJsonObject(get(url));
		JSONArray jsonArray = dataObject.getJSONArray("ticker");
		List<Double> list = jsonArray.toJavaList(Double.class);
		return new FTickerDetailDTO(list);
	}

	/**
	 * 获取ticker行情深度
	 */
	public static FTickerDTO getTickerDepth(String level, String symbol) {
		String url = StringUtils.replace(URL_GET_DEPTH, "$level", level);
		url = StringUtils.replace(url, "$symbol", symbol);
		return JSONObject.parseObject(JsonUtils.getDataStr(get(url)), FTickerDTO.class);
	}

	/**
	 * 获取最新成交明细
	 */
	public static List<FTradesDTO> getTrades(String symbol) {
		String url = StringUtils.replace(URL_GET_TRADES, "$symbol", symbol);
		return JsonUtils.getDataList(get(url), FTradesDTO.class);
	}

	/**
	 * 获取K线图
	 */
	public static List<FKCandleDTO> getKCandle(String resolution, String symbol) {
		String url = StringUtils.replace(URL_GET_CANDLE, "$resolution", resolution);
		url = StringUtils.replace(url, "$symbol", symbol);
		return JsonUtils.getDataList(get(url), FKCandleDTO.class);
	}

}
