package com.erojas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.erojas.model.Specialty;
import com.erojas.service.SpecialtyService;

@Controller
@RequestMapping("/specialtyController")
public class SpecialtyController {

	@Autowired
	private SpecialtyService specialtyService;

	@RequestMapping(path = "/findAll",method = RequestMethod.GET)
	public String findAll(Model model) {
		model.addAttribute("list", specialtyService.findAll());
		return "specialty_list";
	}

	@RequestMapping(path = "/edit/{id}",method = RequestMethod.GET)
	public String edit(Model model, @PathVariable(value = "id") Integer id) {
		if (specialtyService.isUserExist(id)) {
			model.addAttribute("entity", specialtyService.findById(id));
		} else {
			Specialty specialty = new Specialty();
			specialty.setId(specialtyService.generateId());
			model.addAttribute("entity", specialty);
		}
		return "specialty_form";
	}

	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public String save(Model model, Specialty entity) {
		specialtyService.save(entity);
		return findAll(model);
	}

	@RequestMapping(path = "/deleteById/{id}",method = RequestMethod.GET)
	   public String deleteById(Model model, @PathVariable(value = "id") String id) {
		Integer currentId =Integer.parseInt(id);
		if(specialtyService.isUserExist(currentId)) {
			specialtyService.deleteById(currentId);
		}
		return findAll(model);
	}
	
}
