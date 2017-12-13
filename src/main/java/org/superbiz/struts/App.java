package org.superbiz.struts;


import java.util.Collections;

import org.apache.struts2.dispatcher.ActionContextCleanUp;
import org.apache.struts2.dispatcher.FilterDispatcher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.opensymphony.module.sitemesh.filter.PageFilter;

@SpringBootApplication
public class App {

    public static void main(String... args) {
        SpringApplication.run(App.class, args);
    }
    
	@Bean
	public FilterRegistrationBean filterDispatcherFilter() {
	    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new FilterDispatcher());
	    filterRegistrationBean.setInitParameters(Collections.singletonMap("actionPackages", "com.lq"));
	    filterRegistrationBean.addUrlPatterns("/*");
	    filterRegistrationBean.setOrder(1);
	    return filterRegistrationBean;
	}
	
	@Bean
	public FilterRegistrationBean actionContextCleanUpFilter() {
	    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new ActionContextCleanUp());
	    filterRegistrationBean.addUrlPatterns("/*");
	    filterRegistrationBean.setOrder(2);
	    return filterRegistrationBean;
	}
	
	@Bean
	public FilterRegistrationBean pageFilter() {
	    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new PageFilter());
	    filterRegistrationBean.addUrlPatterns("/*");
	    filterRegistrationBean.setOrder(3);
	    return filterRegistrationBean;
	}	
}
