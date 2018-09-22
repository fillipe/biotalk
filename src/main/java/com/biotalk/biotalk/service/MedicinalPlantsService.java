package com.biotalk.biotalk.service;

import java.util.List;

import com.biotalk.biotalk.enums.Status;
import com.biotalk.biotalk.model.MedicinalPlants;

public interface MedicinalPlantsService {
	
	public void saveMedicinalPlants(MedicinalPlants medicinalPlants);
	
	public List<MedicinalPlants> findMedicinalPlantsByStatus(Status status);
	
	public List<MedicinalPlants> findMedicinalPlantsOrIndication(String value);

}
