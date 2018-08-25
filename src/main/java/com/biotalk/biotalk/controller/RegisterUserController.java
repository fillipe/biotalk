package com.biotalk.biotalk.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.biotalk.biotalk.enums.Status;
import com.biotalk.biotalk.model.Authorities;
import com.biotalk.biotalk.model.Formation;
import com.biotalk.biotalk.model.Login;
import com.biotalk.biotalk.model.User;
import com.biotalk.biotalk.service.FormationService;
import com.biotalk.biotalk.service.LoginService;
import com.biotalk.biotalk.service.UserService;

@Controller
@RequestMapping("/registerUser")
public class RegisterUserController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private LoginService loginService;

	@Autowired
	private FormationService formationService;
	
	@GetMapping
	public ModelAndView showRegisterUser() {
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject(new User());
		modelAndView.addObject(new Login());
		modelAndView.addObject(new Authorities());
		modelAndView.addObject(new Formation());
		
		modelAndView.setViewName("anonymous/registerUser");
		return modelAndView;
	}
	
	@PostMapping
	public String save(User user, Login login, Authorities auth, Formation formation, BindingResult result) {

		if(result.hasErrors()) {
			return "redirect:/registerUser";
		} 
		
		try {
			
			if(auth.getIdAuthority() == 3) {
				user.setStatus(Status.APPROVED);
			} else {
				user.setStatus(Status.PENDING);
			}
			
			login.setAuth(auth);
			user.setLogin(login);
			user.setFormation(formation);
			user.setDtCreation(new Date());
			loginService.saveLogin(login);
			formationService.saveFormation(formation);
			userService.saveUser(user);

		} catch (Exception e) {
			System.out.println("Erro ao cadastrar usuário - " + e);
		}

		return "redirect:/login";

	}

}
