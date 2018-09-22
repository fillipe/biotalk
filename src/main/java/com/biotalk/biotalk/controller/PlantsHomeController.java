package com.biotalk.biotalk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlantsHomeController {

	@GetMapping("/anonymous/plantsHome")
	public String returnPlantHome() {
		return "anonymous/plantsHome";
	}
	
	@GetMapping("/comum/plantsHome")
	public String returnPlantHomeComum() {
		return "comum/plantsHome";
	}
	
	@GetMapping("/espec/plantsHome")
	public String returnPlantHomeEspec() {
		return "espec/plantsHome";
	}
	
	@GetMapping("/admin/plantsHome")
	public String returnPlantHomeAdmin() {
		return "admin/plantsHome";
	}
	
}
