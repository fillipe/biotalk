package com.biotalk.biotalk.service;

import com.biotalk.biotalk.model.User;

public interface UserService {
	
	public void saveUser(User user);
	
	public User findUserByCpf(String cpf);

}
