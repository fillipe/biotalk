package com.biotalk.biotalk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.biotalk.biotalk.enums.Status;
import com.biotalk.biotalk.service.MedicinalPlantsService;
import com.biotalk.biotalk.service.ParksService;
import com.biotalk.biotalk.service.UserService;

@Controller
public class PendingAdminController {

	@Autowired
	private UserService userService;

	@Autowired
	private MedicinalPlantsService plantsService;

	@Autowired
	private ParksService parksService;

	@RequestMapping(value = "/pendingUsers")
	public String redirectUsersResults(Model model) {

		try {
			model.addAttribute("usersList", userService.findUserByStatus(Status.PENDING));

		} catch (NullPointerException e) {
			System.out.println("Lista vazia" + e);
		}

		return "admin/pendingUsers";

	}

	@RequestMapping(value = "/pendingPlants")
	public String redirectPlantsResults(Model model) {

		try {
			model.addAttribute("medicinalPlantsList", plantsService.findMedicinalPlantsByStatus(Status.PENDING));

		} catch (NullPointerException e) {
			System.out.println("Lista vazia" + e);
		}

		return "admin/pendingPlants";

	}

	@RequestMapping(value = "/pendingParks")
	public String redirectParksResults(Model model) {

		try {
			model.addAttribute("parksList", parksService.findParksByStatus(Status.PENDING));

		} catch (NullPointerException e) {
			System.out.println("Lista vazia" + e);
		}

		return "admin/pendingPlants";

	}

}
