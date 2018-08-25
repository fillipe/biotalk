package com.biotalk.biotalk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biotalk.biotalk.model.Login;
import com.biotalk.biotalk.repository.LoginRepository;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginRepository;
	
	@Override
	public void saveLogin(Login login) {
		loginRepository.save(login);
		
	}

}
