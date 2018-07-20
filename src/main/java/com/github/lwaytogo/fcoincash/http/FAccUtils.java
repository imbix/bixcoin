package com.github.lwaytogo.fcoincash.http;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.github.lwaytogo.fcoincash.api.ClientAPI;
import com.github.lwaytogo.fcoincash.dto.FAccountsDTO;
import com.github.lwaytogo.fcoincash.dto.FMatchResults;
import com.github.lwaytogo.fcoincash.dto.FOrderCreateDTO;
import com.github.lwaytogo.fcoincash.dto.FOrderDTO;
import com.github.lwaytogo.fcoincash.dto.FOrderQueryDTO;
import com.github.lwaytogo.fcoincash.dto.FResult;
import com.github.lwaytogo.util.JsonUtils;
/**
 * 账户相关操作
 * @author Lidy
 *
 */
public class FAccUtils extends FHttpUtils implements ClientAPI {

	/**
	 * 	获取账户信息
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public static List<FAccountsDTO> getAccounts() {
		String result = getSign(URL_GET_ACCOUNTS);
		return JsonUtils.getDataList(result, FAccountsDTO.class);
	}
	
	/**
	 *  下单
	 */
	public static FResult orderCreate(FOrderCreateDTO ocDTO) {
		String result = postSign(URL_POST_ORDERS,  ocDTO.toParamStr(),JsonUtils.objToStr(ocDTO));
		return new FResult(result);
	}
	
	/**
	 *   查询订单列表
	 */
	public static List<FOrderDTO> orderQuery(FOrderQueryDTO oqDTO) {
		String url = URL_GET_ORDERS;
		if(StringUtils.isNotBlank(oqDTO.toParamStr())) {
			url = url + "?" +oqDTO.toParamStr();
		}
		String result = getSign(url);
		List<FOrderDTO> list = JsonUtils.getDataList(result, FOrderDTO.class);
		return list;
	}
	
	/**
	 * 	获取指定订单
	 */
	public static FOrderDTO orderQueryOne(String orderId) {
		String url = StringUtils.replace(URL_GET_ORDERS_ONE, "{order_id}", orderId);
		String result = getSign(url);
		FOrderDTO oDTO = JsonUtils.getDataObject(result, FOrderDTO.class);
		return oDTO;
	}
	
	/**
	 * 申请撤销订单
	 */
	public static FResult orderCancel(String orderId) {
		String url = StringUtils.replace(URL_POST_ORDERS_SUBMIT_CANCEL, "{order_id}", orderId);
		String result = getSign(url);
		System.out.println("result:" + result);
		return new FResult(result);
	}
	
	/**
	 * 查询指定订单的成交记录
	 */
	public static FMatchResults orderMatchResults(String orderId) {
		String url = StringUtils.replace(URL_GET_ORDERS_MATCH_RESULTS, "{order_id}", orderId);
		String result = getSign(url);
		FMatchResults mResult = JsonUtils.getDataObject(result, FMatchResults.class);
		return mResult;
	}
	
	
}
