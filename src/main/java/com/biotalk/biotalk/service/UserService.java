package com.biotalk.biotalk.service;

import java.util.List;

import com.biotalk.biotalk.enums.Status;
import com.biotalk.biotalk.model.User;

public interface UserService {
	
	public void saveUser(User user);
	
	public User findUserByCpf(String cpf);

	public User findUserByIdLogin(String value);
	
	public List<User> findUserByStatus(Status status);

}
