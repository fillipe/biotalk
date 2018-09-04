package com.biotalk.biotalk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.biotalk.biotalk.enums.Status;
import com.biotalk.biotalk.model.MedicinalPlants;

@Repository("medicinalPlantsRepository")
public interface MedicinalPlantsRepository extends JpaRepository<MedicinalPlants, Long>, CrudRepository<MedicinalPlants, Long> {
	
	List<MedicinalPlants> findByStatus(Status status);

}
