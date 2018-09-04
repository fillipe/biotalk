package com.biotalk.biotalk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.biotalk.biotalk.enums.Status;
import com.biotalk.biotalk.model.Parks;

@Repository("parksRepository")
public interface ParksRepository extends JpaRepository<Parks, Long>, CrudRepository<Parks, Long> {
	
	List<Parks> findByStatus(Status status);

}
