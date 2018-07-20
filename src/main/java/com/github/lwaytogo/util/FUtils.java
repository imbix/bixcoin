package com.github.lwaytogo.util;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.HmacUtils;

import com.github.lwaytogo.fcoincash.dto.FOrderCreateDTO;

/**
 * 常用工具类
 * 
 * @author Lidy
 *
 */
public class FUtils {
	


	public static void main(String[] args) throws UnsupportedEncodingException {

		FOrderCreateDTO dto = new FOrderCreateDTO();
		dto.setSymbol("ftusdt");
		dto.setSide("buy");
		dto.setType("limit");
		dto.setPrice(0.1D);
		dto.setAmount(1D);


	}

	

	

	

	

}
