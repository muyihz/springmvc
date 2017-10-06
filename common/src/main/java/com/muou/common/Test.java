package com.muou.common;

import java.math.BigDecimal;
import java.util.HashMap;

import org.apache.commons.collections.CollectionUtils;

import com.alibaba.fastjson.JSONObject;

public class Test {
	public static void main(String[] args) {
		//String str = "{\"head/A\":\"aaaaa\",\"head/B\":\"bbbbbbb\",\"AAAA\":\"aa\",\"aa\":\"AA\"}";
		//HashMap map = JSONObject.parseObject(str, HashMap.class);
		//System.out.println(map);
		
		String amt =  "2.1";
		if(amt!=null && amt.contains(".")){
			amt = amt + "00";
			System.out.println(amt);
			amt =  amt.substring(0,amt.indexOf(".")+3);
		}
		System.out.println(amt);
		BigDecimal ss = new BigDecimal(amt);
		System.out.println(ss);
		//CollectionUtils.select(inputCollection, predicate);
	}
	

}
