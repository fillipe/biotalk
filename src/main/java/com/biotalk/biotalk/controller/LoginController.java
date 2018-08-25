package com.biotalk.biotalk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String returnLogin() {
		return "anonymous/login";
	}
	
	@GetMapping("auth/homepage")
	public String returnHomePage() {
		return "authenticated/homepage";
	}
	
	@GetMapping("app/error")
	public String returnAccesDenied() {
		return "errorAccessDenied";
	}

}
