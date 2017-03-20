package com.jungang.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping("/form")
	public String getLoginForm(HttpServletRequest request) {
		
		return "loginform";
	}
	
	
}
