package com.biotalk.biotalk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.biotalk.biotalk.enums.Status;
import com.biotalk.biotalk.model.MedicinalPlants;

@Repository("medicinalPlantsRepository")
public interface MedicinalPlantsRepository extends JpaRepository<MedicinalPlants, Integer>, CrudRepository<MedicinalPlants, Integer> {
	
	List<MedicinalPlants> findByStatus(Status status);
	
	@Query("SELECT mp "
			+ "FROM MedicinalPlants mp, MedicinalIndication mi "
			+ "WHERE mp.plantsId = mi.medicinalPlants "
			+ "and (upper(mp.scientificName) like upper(:value) "
			+ "or upper(mp.otherName) like upper(:value) "
			+ "or upper(mi.indication) like upper(:value)) "
			+ "and mp.status = 1 ")
	List<MedicinalPlants> findByMedicinalPlantsOrIndication(@Param("value") String value);

}
