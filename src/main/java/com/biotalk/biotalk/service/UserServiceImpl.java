package com.biotalk.biotalk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biotalk.biotalk.model.User;
import com.biotalk.biotalk.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void saveUser(User user) {
		userRepository.save(user);
		
	}

	@Override
	public User findUserByCpf(String cpf) {
		return userRepository.findByCpf(cpf);
	}

}
