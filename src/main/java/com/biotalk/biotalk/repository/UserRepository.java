package com.biotalk.biotalk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.biotalk.biotalk.enums.Status;
import com.biotalk.biotalk.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer>, CrudRepository<User, Integer> {

	User findByCpf(String cpf);

	@Query("select u "
			+ "from User u, Login l "
			+ "where u.login = l.idLogin "
			+ "and l.email= :value ")
	User findIdLoginByEmail(@Param("value") String value);

	List<User> findByStatus(Status status);

}
