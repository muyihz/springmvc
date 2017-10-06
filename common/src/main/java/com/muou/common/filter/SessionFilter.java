package com.muou.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.muou.common.util.PubUtil;


public class SessionFilter  implements Filter{
    private  Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Value("${key}")
    private String value; 
   
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub
        
    }
    public void doFilter(ServletRequest req, ServletResponse resp,  FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        String params = PubUtil.getParamValue(request);
        logger.info(params);
        chain.doFilter(request, response);
    }

    public void destroy() {
        // TODO Auto-generated method stub
        
    }

}
