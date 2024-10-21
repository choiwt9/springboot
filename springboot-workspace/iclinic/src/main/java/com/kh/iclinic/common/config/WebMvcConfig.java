package com.kh.iclinic.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.kh.iclinic.common.intercepter.LoginItercepter;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
	
	private final LoginItercepter loginItercepter;
	
	public WebMvcConfig(LoginItercepter loginItercepter) {
		this.loginItercepter = loginItercepter;
	}
     @Override
	public void addInterceptors(InterceptorRegistry registry) {
    	 registry.addInterceptor(loginItercepter)
 		.addPathPatterns("/counsel/");
     }
	}
	