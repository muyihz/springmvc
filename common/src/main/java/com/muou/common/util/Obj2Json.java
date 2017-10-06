package com.muou.common.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Obj2Json {
	/**
	 * java obj convvert to json
	 * @param obj
	 * @return
	 */
	public static JSONObject obj2Json(Object obj){
		JSONObject json = (JSONObject) JSONObject.toJSON(obj);
		return json;
	}
	/**
	 * java obj convvert to JSONArray
	 * @param obj
	 * @return
	 */
	public static JSONArray obj2JsonArray(Object obj){
		JSONArray json = (JSONArray) JSONObject.toJSON(obj);
		return json;
	}
}
