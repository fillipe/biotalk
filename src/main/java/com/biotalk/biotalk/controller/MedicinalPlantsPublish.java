package com.biotalk.biotalk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.biotalk.biotalk.enums.Status;
import com.biotalk.biotalk.model.MedicalContraindication;
import com.biotalk.biotalk.model.MedicinalIndication;
import com.biotalk.biotalk.model.MedicinalPlants;
import com.biotalk.biotalk.model.PicPlants;
import com.biotalk.biotalk.service.MedicinalPlantsService;
import com.biotalk.biotalk.service.PicPlantsService;

@Controller
public class MedicinalPlantsPublish {
	
	@Autowired
	private MedicinalPlantsService medicinalPlantsService;
	
	@Autowired
	private PicPlantsService picPlantsService;
	
	@GetMapping(value = { "/espec/plantsPublish" })
	public ModelAndView plantsPublish() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject(new MedicinalPlants());
		modelAndView.addObject(new MedicinalIndication());
		modelAndView.addObject(new MedicalContraindication());
		modelAndView.addObject(new PicPlants());

		modelAndView.setViewName("espec/plantsPublish");

		return modelAndView;

	}

	@PostMapping(value = { "/espec/plantsPublish" })
	public String save(MedicinalPlants medicinalPlants, MedicinalIndication medicinalIndication,
			MedicalContraindication medicalContraindication, PicPlants picPlants) {

		try {

			medicinalPlants.setMedicinalIndication(medicinalIndication);
			medicinalPlants.setMedicalContraindication(medicalContraindication);
			medicinalPlants.setPicPlants(picPlants);
			medicinalPlants.setStatus(Status.PENDING);
			// medicinalPlants.setUser();
			medicinalPlantsService.saveMedicinalPlants(medicinalPlants);
			picPlantsService.savePlants(picPlants);

		} catch (Exception e) {
			System.out.println("Erro ao cadastrar planta medicinal - " + e);
		}

		return "redirect:/espec/homepage";

	}

}
