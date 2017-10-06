package com.muou.common.controller;

import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.muou.common.dao.UserInfoDao;
import com.muou.common.util.Obj2Json;
import com.muou.common.util.SpringContextUtil;

@Controller
public class TestController {
	private Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	private RedisTemplate redisTemplate;
	@Autowired
	private UserInfoDao userInfoDao;
	@Autowired
	private SpringContextUtil springContextUtil;
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@RequestMapping(value = "test.do")
	public String  test(){
		logger.info("==============" + Obj2Json.obj2Json(userInfoDao.getUserInfo(1)));
		return "home";
	}
	@ResponseBody
	@RequestMapping(value = "getInput.do")
	public String  getInput(HttpServletRequest request,HttpServletResponse response) throws Exception{
		InputStream in = request.getInputStream();
		byte[] b = new byte[request.getContentLength()];
		in.read(b);
		String str = new String(b);
		logger.info("============"+str);
		return str;
	}
	
	@ResponseBody
	@RequestMapping(value = "redis.do")
	public String  redis(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ValueOperations<String,String> operations = redisTemplate.opsForValue();
		operations.set("key1", "11111111111");
		String  value1 = operations.get("key1");
		logger.info("============"+value1);
		return value1;
	}
	@ResponseBody
	@RequestMapping(value = "param.do")
	public String  param(HttpServletRequest request,HttpServletResponse response){
		
		logger.info("11111111111111111111111111");
		return "1111111111111111";
	}
}
