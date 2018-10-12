package com.biotalk.biotalk.controller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.biotalk.biotalk.enums.Status;
import com.biotalk.biotalk.model.MedicalContraindication;
import com.biotalk.biotalk.model.MedicinalIndication;
import com.biotalk.biotalk.model.MedicinalPlants;
import com.biotalk.biotalk.model.PicPlants;
import com.biotalk.biotalk.model.User;
import com.biotalk.biotalk.service.MedicinalPlantsService;
import com.biotalk.biotalk.service.PicPlantsService;
import com.biotalk.biotalk.service.UserService;

@Controller
public class MedicinalPlantsPublishController {

	@Autowired
	private MedicinalPlantsService medicinalPlantsService;

	@Autowired
	private PicPlantsService picPlantsService;

	@Autowired
	private UserService userService;

	@GetMapping(value = { "/espec/plantsPublish" })
	public ModelAndView plantsPublish() {
		ModelAndView modelAndView = new ModelAndView();
		
		Set<MedicinalIndication> listIndication = new HashSet<>();
		Set<MedicinalIndication> listContraindication = new HashSet<>();

		modelAndView.addObject(new MedicinalPlants());
		modelAndView.addObject(listIndication);
		modelAndView.addObject(listContraindication);
		modelAndView.addObject(new PicPlants());

		modelAndView.setViewName("espec/plantsPublish");

		return modelAndView;

	}

	@PostMapping(value = { "/espec/plantsPublish" })
	public String save(MedicinalPlants medicinalPlants, Set<MedicinalIndication> medicinalIndication,
			Set<MedicalContraindication> medicalContraindication, PicPlants picPlants) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		User user = userService.findUserByIdLogin(authentication.getName());

		//TODO @ManyToMany salvar
		medicinalPlants.setMedicinalIndication(medicinalIndication);
		medicinalPlants.setMedicalContraindication(medicalContraindication);
		medicinalPlants.setPicPlants(picPlants);
		medicinalPlants.setStatus(Status.PENDING);
		medicinalPlants.setUser(user);

		medicinalPlantsService.saveMedicinalPlants(medicinalPlants);
		picPlants.setMedicinalPlants(medicinalPlants);
		picPlantsService.savePlants(picPlants);

		return "redirect:/espec/plantsPublish?success=true";

	}
	
}
