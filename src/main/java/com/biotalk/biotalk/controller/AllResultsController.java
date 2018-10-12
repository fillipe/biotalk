package com.biotalk.biotalk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.biotalk.biotalk.model.MedicinalPlants;
import com.biotalk.biotalk.service.MedicinalPlantsService;
import com.biotalk.biotalk.service.UserService;

@Controller
@SessionAttributes("searchValue")
public class AllResultsController {

	@Autowired
	private UserService userService;

	@Autowired
	private MedicinalPlantsService plantsService;

	@GetMapping(value = "/anonymous/allResults")
	public String redirectResultsAnonymous(@ModelAttribute("searchValue") String value, Model model) {

		List<MedicinalPlants> medicinalPlantsList = plantsService.findMedicinalPlantsOrIndication(value);

		if (medicinalPlantsList != null) {
			model.addAttribute("medicinalPlantsList", medicinalPlantsList);
		} else {
			return "/anonymous/homepage";
		}

		return "anonymous/allResults";
	}

	@GetMapping(value = "/comum/allResultsComum")
	public String redirectResultsComum(@ModelAttribute("searchValue") String value, Model model) {

		List<MedicinalPlants> medicinalPlantsList = plantsService.findMedicinalPlantsOrIndication(value);

		if (medicinalPlantsList != null) {
			model.addAttribute("medicinalPlantsList", medicinalPlantsList);
		} else {
			return "/comum/homepage";
		}

		return "comum/allResultsComum";
	}
	
	@GetMapping(value = "/espec/allResultsEspec")
	public String redirectResultsEspec(@ModelAttribute("searchValue") String value, Model model) {

		List<MedicinalPlants> medicinalPlantsList = plantsService.findMedicinalPlantsOrIndication(value);

		if (medicinalPlantsList != null) {
			model.addAttribute("medicinalPlantsList", medicinalPlantsList);
		} else {
			return "/espec/homepage";
		}

		return "espec/allResultsEspec";
	}

	@GetMapping(value = "/espec/allResultsAdmin")
	public String redirectResultsAdmin(@ModelAttribute("searchValue") String value, Model model) {

		List<MedicinalPlants> medicinalPlantsList = plantsService.findMedicinalPlantsOrIndication(value);

		if (medicinalPlantsList != null) {
			model.addAttribute("medicinalPlantsList", medicinalPlantsList);
		} else {
			return "/admin/homepage";
		}

		return "admin/allResultsAdmin";
	}

	//
	// @RequestMapping(value = "/valuePlantsByIdAdmin/{id}")
	// public String redirectResultsPlant(@PathVariable Integer id, Model model)
	// {
	//
	// List<Object[]> list = plantsDAO.findPlantsById(id);
	//
	// for (Object o[] : list) {
	// MedicinalPlants mp = (MedicinalPlants) o[0];
	// PicPlants pp = (PicPlants) o[1];
	//
	// model.addAttribute("medicinalPlants", mp);
	// model.addAttribute("picPlants", pp);
	// }
	//
	// return "admin/resultPlants";
	// }
	//
	// @RequestMapping(value = "/valueParksByIdAdmin/{id}")
	// public String redirectResultsPark(@PathVariable Integer id, Model model)
	// {
	//
	// List<Object[]> list = parkDAO.searchParkByID(id);
	//
	// for (Object o[] : list) {
	// Parks p = (Parks) o[0];
	// PicParks pp = (PicParks) o[1];
	//
	// model.addAttribute("park", p);
	// model.addAttribute("picParks", pp);
	// }
	//
	// return "admin/resultParks";
	// }
	//
	// @RequestMapping(value = "/valueUserByIdAdmin/{id}")
	// public String redirectResultsUser(@PathVariable Integer id, Model model)
	// {
	//
	// List<Object[]> list = userDAO.searchUserAndFormationAndLoginById(id);
	//
	// for (Object o[] : list) {
	// User u = (User) o[0];
	// Login l = (Login) o[1];
	// // Profile p = (Profile) o[2];
	// Formation f = (Formation) o[2];
	//
	// model.addAttribute("user", u);
	// model.addAttribute("login", l);
	// // model.addAttribute("profile", p);
	// model.addAttribute("formation", f);
	// }
	//
	// return "admin/resultUser";
	// }
	//
	// @RequestMapping(value = "/valuePlantsById/{id}")
	// public String redirectResultsPlantLogout(@PathVariable Integer id, Model
	// model) {
	//
	// List<Object[]> list = plantsDAO.findPlantsById(id);
	//
	// for (Object o[] : list) {
	// MedicinalPlants mp = (MedicinalPlants) o[0];
	// PicPlants pp = (PicPlants) o[1];
	//
	// model.addAttribute("medicinalPlants", mp);
	// model.addAttribute("picPlants", pp);
	// }
	//
	// return "/resultPlants";
	// }
	//
	// @RequestMapping(value = "/valueParksById/{id}")
	// public String redirectResultsParkLogout(@PathVariable Integer id, Model
	// model) {
	//
	// List<Object[]> list = parkDAO.searchParkByID(id);
	//
	// for (Object o[] : list) {
	// Parks p = (Parks) o[0];
	// PicParks pp = (PicParks) o[1];
	//
	// model.addAttribute("park", p);
	// model.addAttribute("picParks", pp);
	// }
	//
	// return "/resultParks";
	// }
	//
	// @RequestMapping(value = "/valuePlantsByIdEspec/{id}")
	// public String redirectResultsPlantEspec(@PathVariable Integer id, Model
	// model) {
	//
	// List<Object[]> list = plantsDAO.findPlantsById(id);
	//
	// for (Object o[] : list) {
	// MedicinalPlants mp = (MedicinalPlants) o[0];
	// PicPlants pp = (PicPlants) o[1];
	//
	// model.addAttribute("medicinalPlants", mp);
	// model.addAttribute("picPlants", pp);
	// }
	//
	// return "espec/resultPlants";
	// }
	//
	// @RequestMapping(value = "/valueParksByIdEspec/{id}")
	// public String redirectResultsParkEspec(@PathVariable Integer id, Model
	// model) {
	//
	// List<Object[]> list = parkDAO.searchParkByID(id);
	//
	// for (Object o[] : list) {
	// Parks p = (Parks) o[0];
	// PicParks pp = (PicParks) o[1];
	//
	// model.addAttribute("park", p);
	// model.addAttribute("picParks", pp);
	// }
	//
	// return "espec/resultParks";
	// }

}