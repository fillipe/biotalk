package com.biotalk.biotalk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biotalk.biotalk.enums.Status;
import com.biotalk.biotalk.model.MedicinalPlants;
import com.biotalk.biotalk.repository.MedicinalPlantsRepository;

@Service("medicinalPlantsService")
public class MedicinalPlantsServiceImpl implements MedicinalPlantsService {
	
	@Autowired
	private MedicinalPlantsRepository plantsRepository;

	@Override
	public void saveMedicinalPlants(MedicinalPlants medicinalPlants) {
		plantsRepository.save(medicinalPlants);
	}

	@Override
	public List<MedicinalPlants> findMedicinalPlantsByStatus(Status status) {
		return plantsRepository.findByStatus(status);
	}
	
	@Override
	public List<MedicinalPlants> findMedicinalPlantsOrIndication(String value) {
		String valueContaining = "%" + value + "%";
		return plantsRepository.findByMedicinalPlantsOrIndication(valueContaining);
	}

}
