package com.biotalk.biotalk.service;

import java.util.List;

import com.biotalk.biotalk.enums.Status;
import com.biotalk.biotalk.model.MedicinalPlants;

public interface MedicinalPlantsService {
	
	public List<MedicinalPlants> findMedicinalPlantsByStatus(Status status);

}
