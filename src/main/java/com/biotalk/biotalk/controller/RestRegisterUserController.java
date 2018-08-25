package com.biotalk.biotalk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biotalk.biotalk.service.UserService;

@RestController
@RequestMapping("/api/user")
public class RestRegisterUserController {
	
	@Autowired
	private UserService userService;

	@GetMapping(value = "/verifyByCpf/{cpf}")
	public Boolean verifyUserByCpf(@PathVariable String cpf) {
		return userService.findUserByCpf(cpf) != null;
	}

}
