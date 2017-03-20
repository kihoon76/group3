package com.jungang.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
	
	@GetMapping("main")
	public String viewMain(ModelMap map) {
		
		return "main";
	}
	
	@GetMapping("register")
	public String viewRegister(HttpServletRequest req) {
		return "register";
	}
}
