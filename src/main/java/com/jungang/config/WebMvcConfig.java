package com.jungang.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.jungang.interceptor.LoginInterceptor;

@Configuration
public class WebMvcConfig {
	
	@Bean
	public WebMvcConfigurerAdapter webMvcConfigurerAdapter(@Qualifier("loginInterceptor") LoginInterceptor loginInterceptor) {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				
				registry.addInterceptor(loginInterceptor).addPathPatterns(new String[] {"/*"});
			}
		};
	}
}
