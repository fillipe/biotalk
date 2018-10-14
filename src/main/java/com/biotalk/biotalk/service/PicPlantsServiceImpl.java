package com.biotalk.biotalk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biotalk.biotalk.model.PicPlants;
import com.biotalk.biotalk.repository.PicPlantsRepository;

@Service(value = "picPlantsService")
public class PicPlantsServiceImpl implements PicPlantsService {
	
	@Autowired
	private PicPlantsRepository picPlantsRepository;
	
	public void savePlants(PicPlants picPlants) {
		picPlantsRepository.save(picPlants);
	}

}
