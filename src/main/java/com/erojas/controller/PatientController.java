package com.erojas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.erojas.model.Patient;
import com.erojas.service.PatientService;

@Controller
@RequestMapping("/patientController")
public class PatientController {
	@Autowired
	private PatientService patientService;
	
	@RequestMapping(path = "/findAll",method = RequestMethod.GET)
	public String findAll(Model model) {
		model.addAttribute("list", patientService.findAll());
		return "patient_list";
	}

	@RequestMapping(path = "/edit/{id}",method = RequestMethod.GET)
	public String edit(Model model, @PathVariable(value = "id") Integer id) {
		if (patientService.isUserExist(id)) {
			model.addAttribute("entity", patientService.findById(id));
		} else {
			Patient patient = new Patient();
			patient.setId(patientService.generateId());
			model.addAttribute("entity", patient);
		}
		return "patient_form";
	}

	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public String save(Model model, Patient entity) {
			patientService.save(entity);
	
			return findAll(model);
	}

	@RequestMapping(path = "/deleteById/{id}",method = RequestMethod.GET)
	   public String deleteById(Model model, @PathVariable(value = "id") Integer id) {
		if(patientService.isUserExist(id)) {
			patientService.deleteById(id);
		}
		return findAll(model);
	}
}
