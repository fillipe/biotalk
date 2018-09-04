package com.biotalk.biotalk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.biotalk.biotalk.enums.Status;
import com.biotalk.biotalk.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long>, CrudRepository<User, Long> {
	
	User findByCpf(String cpf);
	
	List<User> findByStatus(Status status);

}
