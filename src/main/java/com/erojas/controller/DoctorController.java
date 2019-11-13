package com.erojas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.erojas.dto.DoctorSpecialty;
import com.erojas.model.Doctor;
import com.erojas.model.Specialty;
import com.erojas.service.DoctorService;
import com.erojas.service.SpecialtyService;

@Controller
@RequestMapping("/doctorController")
public class DoctorController {
	@Autowired
	private DoctorService doctorService;

	@Autowired
	private SpecialtyService specialtyService;

	@RequestMapping(path = "/findAll", method = RequestMethod.GET)
	public String findAll(Model model) {
		model.addAttribute("list", doctorService.findAll());
		return "doctor_list";
	}

	@RequestMapping(path = "/edit/{id}", method = RequestMethod.GET)
	public String edit(Model model, @PathVariable(value = "id") Integer id) {
		if (id == 0) {
			Doctor doctor = new Doctor();
			doctor.setId(doctorService.generateId());
			model.addAttribute("entity", doctor);
		} else {
			model.addAttribute("entity", doctorService.findById(id).get());
		}
		model.addAttribute("option", id);
		model.addAttribute("listSpecialty", specialtyService.findAll());
		return "doctor_form";
	}

	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public String save(Model model, @RequestParam(value = "id") Integer id,
			@RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName,
			@RequestParam(value = "dni") String dni,
			@RequestParam(value = "nameSpecialty", required = false) String nameSpecialty,
			@RequestParam(value = "idSpecialty") Integer idSpecialty) {

		Doctor doctor = new Doctor();
		doctor.setId(Long.valueOf(id));
		doctor.setFirstName(firstName);
		doctor.setLastName(lastName);
		doctor.setDni(dni);

		Specialty specialty = specialtyService.findById(idSpecialty).get();
		doctor.setSpecialty(specialty);

		doctorService.save(doctor);
		return findAll(model);
	}

	@RequestMapping(path = "/deleteById/{id}", method = RequestMethod.GET)
	public String deleteById(Model model, @PathVariable(value = "id") Integer id) {
		if (doctorService.isUserExist(id)) {
			doctorService.deleteById(id);
		}
		return findAll(model);
	}

	@RequestMapping(path = "/findAll/orderyBySpecialty", method = RequestMethod.GET)
	public String findAllOrderyBySpecialty(Model model) {
		
		model.addAttribute("list", doctorService.findAllOrderyBySpecialty());
		return "doctor_list_oder_specialty";
	}

}
