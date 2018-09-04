package com.biotalk.biotalk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ParksHomeController {

	@GetMapping("/parksHome")
	public String returnParksHome() {
		return "anonymous/parksHome";
	}
	
	@GetMapping("auth/parksHome")
	public String returnPlantHomeAuth() {
		return "auth/parksHome";
	}
	
}
