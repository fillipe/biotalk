package com.biotalk.biotalk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlantsHomeController {

	@GetMapping("/plantsHome")
	public String returnPlantHome() {
		return "anonymous/plantsHome";
	}
	
}
