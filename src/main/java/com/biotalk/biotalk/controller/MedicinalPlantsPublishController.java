package com.biotalk.biotalk.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.biotalk.biotalk.enums.Status;
import com.biotalk.biotalk.model.MedicinalIndication;
import com.biotalk.biotalk.model.MedicinalPlants;
import com.biotalk.biotalk.model.PicPlants;
import com.biotalk.biotalk.model.User;
import com.biotalk.biotalk.service.MedicinalPlantsService;
import com.biotalk.biotalk.service.PicPlantsService;
import com.biotalk.biotalk.service.UserService;

@Controller
public class MedicinalPlantsPublishController {
	
	private static final String AJAX_HEADER_NAME = "X-Requested-With";
    private static final String AJAX_HEADER_VALUE = "XMLHttpRequest";

	@Autowired
	private MedicinalPlantsService medicinalPlantsService;

	@Autowired
	private PicPlantsService picPlantsService;

	@Autowired
	private UserService userService;

	@GetMapping(value = { "/espec/plantsPublish" })
	public ModelAndView plantsPublish() {
		ModelAndView modelAndView = new ModelAndView();
		
		MedicinalPlants medicinalPlants = new MedicinalPlants();
		List<MedicinalIndication> medicinalIndication = new ArrayList<>();
		
		medicinalPlants.setMedicinalIndication(medicinalIndication);
		medicinalPlants.setMedicalContraindication(new HashSet<>());
		medicinalPlants.setPicPlants(new PicPlants());

		modelAndView.addObject(medicinalPlants);

		modelAndView.setViewName("espec/plantsPublish");

		return modelAndView;

	}

	@RequestMapping(value = {"/espec/plantsPublish"}, params = {"save"})
	public String save(MedicinalPlants medicinalPlants) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		User user = userService.findUserByIdLogin(authentication.getName());

		//TODO @ManyToMany salvar
		medicinalPlants.setStatus(Status.PENDING);
		medicinalPlants.setUser(user);

		medicinalPlantsService.saveMedicinalPlants(medicinalPlants);
		picPlantsService.savePlants(medicinalPlants.getPicPlants());

		return "redirect:/espec/plantsPublish?success=true";

	}
	
	@RequestMapping(value = {"/espec/plantsPublish"}, params = {"addItem"})
    public String addIndication(MedicinalPlants medicinalPlants, HttpServletRequest request, Model model) {
		List<MedicinalIndication> indications = medicinalPlants.getMedicinalIndication() != null ? medicinalPlants.getMedicinalIndication() : new ArrayList<>();
		MedicinalIndication indication = new MedicinalIndication();
		indication.setIndication("");
		indications.add(indication);
		
		medicinalPlants.setMedicinalIndication(indications);
		
		model.addAttribute("medicinalPlants", medicinalPlants);
        if (AJAX_HEADER_VALUE.equals(request.getHeader(AJAX_HEADER_NAME))) {
            // It is an Ajax request, render only #items fragment of the page.
            return "espec/plantsPublish::#indications";
        } else {
            // It is a standard HTTP request, render whole page.
            return "espec/plantsPublish";
        }
    }

    // "removeItem" parameter contains index of a item that will be removed.
    @PostMapping(params = "removeItem", path = {"/espec/plantsPublish"})
    public String removeIndication(MedicinalPlants medicinalPlants, @RequestParam("removeItem") int index, HttpServletRequest request) {
    	medicinalPlants.getMedicinalIndication().remove(index);
        if (AJAX_HEADER_VALUE.equals(request.getHeader(AJAX_HEADER_NAME))) {
            return "espec/plantsPublish::#indications";
        } else {
            return "espec/plantsPublish";
        }
    }
	
}
