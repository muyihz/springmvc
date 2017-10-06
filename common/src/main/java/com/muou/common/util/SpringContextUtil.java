package com.muou.common.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

//@Alias
public class SpringContextUtil  implements ApplicationContextAware{
    @Autowired
	private ApplicationContext applicationContext;
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}
	public  <T> T getBean(Class<T> clazz){
		T t = applicationContext.getBean(clazz);
		return t;
	}
	
	public  <T> T getBean(String beanName){
		T t = (T) applicationContext.getBean(beanName);
		return t;
	}
	
}
