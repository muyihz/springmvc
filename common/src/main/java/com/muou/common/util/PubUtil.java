package com.muou.common.util;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class PubUtil {
    
    
    /**
     * 普通bean获取request对象
     * @return
     */
    public static HttpServletRequest getReq(){
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }
    
    
    /**
     * 获取提示信息
     * @param key
     * @return
     */
    
    public static String returnMsg(String key){
        HttpServletRequest request = getReq();
        ServletContext context = request.getSession().getServletContext();  
        WebApplicationContext ctx  = WebApplicationContextUtils.getWebApplicationContext(context);
        String message  = ctx.getMessage(key, null, request.getLocale());
        return message;
    }
    
    
    /**
     * 获取所有的参数
     * @param request
     * @return
     */
    public static String getParamValue(HttpServletRequest request){
        StringBuffer  buffer = new StringBuffer("参数为     :    ");
        Enumeration enu =  request.getParameterNames();
        while(enu.hasMoreElements()){
            String paramBame = (String)enu.nextElement();
            String paramValue = request.getParameter(paramBame);
            buffer.append(paramBame + ":" + paramValue + "    ");
        }
        return buffer.toString();
    }
}
