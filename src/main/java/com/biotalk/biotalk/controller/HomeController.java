package com.biotalk.biotalk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/anonymous/homepage")
	public String returnHomePage() {
		return "anonymous/homepage";
	}

	@GetMapping("/comum/homepage")
	public String returnHomePageComum() {
		return "comum/homepage";
	}
	
	@GetMapping("/espec/homepage")
	public String returnHomePageEspec() {
		return "espec/homepage";
	}
	
	@GetMapping("/admin/homepage")
	public String returnHomePageAdmin() {
		return "admin/homepage";
	}
	
	
	
}
