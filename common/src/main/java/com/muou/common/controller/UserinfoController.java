package com.muou.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.muou.common.util.SessionCreateUtil;

@Controller
public class UserinfoController {
	private Log logger = LogFactory.getLog(this.getClass());
	
	@RequestMapping(value = "login.do")
	@ResponseBody
	public String login(
			@RequestParam(required=true,value ="userName")String userName,
            @RequestParam(required=true,value ="password")String password){
		JSONObject json = new JSONObject();
		json.put("username", userName);
		json.put("retCode", "000000");
		json.put("retMsg", "成功");
		json.put("X-SESSION-ID", SessionCreateUtil.createSessionId());
		logger.info(json.toJSONString());
		return json.toJSONString();
	}
	
}
