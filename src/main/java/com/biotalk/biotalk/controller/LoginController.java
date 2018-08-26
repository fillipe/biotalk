package com.biotalk.biotalk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	@PostMapping("app-logout")
	public String returnLogout() {
		return "anonymous/login";
	}
	
	@GetMapping("app/error")
	public String returnAccesDenied() {
		return "errorAccessDenied";
	}

}
