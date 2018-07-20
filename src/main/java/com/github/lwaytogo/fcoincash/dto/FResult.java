package com.github.lwaytogo.fcoincash.dto;

import com.alibaba.fastjson.JSONObject;

/**
 *  结果
 * @author Lidy
 *
 */
public class FResult {
	/**
	 * 0:成功，1016：余额不足
	 */
	private String status;
	private String msg;
	private Object data;
	
	
	public FResult() {
		
	}
	
	public FResult(String jsonStr) {
		JSONObject jsonObject = JSONObject.parseObject(jsonStr);
		String status = jsonObject.getString("status");
		String msg = jsonObject.getString("msg");
		Object data = jsonObject.get("msg");
		this.setStatus(status);
		this.setMsg(msg);
		this.setData(data);
	}
	
	public FResult(String status, String msg) {
		super();
		this.status = status;
		this.msg = msg;
	}

	/**
	 * 	是否成功
	 */
	public boolean isOk() {
		if("0".equals(this.getStatus())) {
			return true;
		}
		return false;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "FResult [status=" + status + ", msg=" + msg + ", data=" + data + "]";
	}
	
	
	
	
}
