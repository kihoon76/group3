package com.jungang.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class LoginInterceptor extends BaseInterceptor {
	
	public LoginInterceptor() {
		super(LoginInterceptor.class);
	}
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		

		return true;
	}
}
