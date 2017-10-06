package com.muou.common.util;

import java.util.UUID;

public class SessionCreateUtil {
	
	public static String createSessionId(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
