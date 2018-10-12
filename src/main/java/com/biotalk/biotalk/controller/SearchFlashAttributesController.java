package com.biotalk.biotalk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SearchFlashAttributesController {
	
	@GetMapping(value = "/anonymous/search")
	public ModelAndView search(@RequestParam(value="value",required=false) String value, RedirectAttributes attributes){
		attributes.addFlashAttribute("searchValue", value);
		
		return new ModelAndView("redirect:allResults");
	}
	
	@GetMapping(value = "/espec/search")
	public ModelAndView searchEspec(@RequestParam(value="value",required=false) String value, RedirectAttributes attributes){
		attributes.addFlashAttribute("searchValue", value);
		
		return new ModelAndView("redirect:allResultsEspec");
	}
	
	@GetMapping(value = "/admin/search")
	public ModelAndView searchAdmin(@RequestParam(value="value",required=false) String value, RedirectAttributes attributes){
		attributes.addFlashAttribute("searchValue", value);
		
		return new ModelAndView("redirect:allResultsAdmin");
	}
	
}
