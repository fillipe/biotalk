package com.biotalk.biotalk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biotalk.biotalk.model.Login;

@Repository("loginRepository")
public interface LoginRepository extends JpaRepository<Login, Long> {
	
	Login findByEmail(String email);
	
}
