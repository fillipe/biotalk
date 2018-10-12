package com.biotalk.biotalk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.biotalk.biotalk.model.PicPlants;

@Repository(value = "picPlantsRepository")
public interface PicPlantsRepository extends JpaRepository<PicPlants, Integer>, CrudRepository<PicPlants, Integer>{

}
