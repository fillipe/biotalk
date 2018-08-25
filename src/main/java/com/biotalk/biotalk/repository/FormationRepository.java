package com.biotalk.biotalk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.biotalk.biotalk.model.Formation;

@Repository("formationRepository")
public interface FormationRepository extends JpaRepository<Formation, Long>, CrudRepository<Formation, Long> {

}
