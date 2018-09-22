package com.biotalk.biotalk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.biotalk.biotalk.model.Login;
import com.biotalk.biotalk.model.User;

@Controller
@RequestMapping(value = "/anonymous/forgotPassword")
@SessionAttributes("email")
public class ForgotPasswordController {
	
	@GetMapping
	public ModelAndView returnForgotPass() {
		
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject(new Login());
		modelAndView.addObject(new User());
		
		modelAndView.setViewName("anonymous/forgotPassword");
		
		return modelAndView;
	}
	
}
