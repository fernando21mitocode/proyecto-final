package com.erojas.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.erojas.dto.TreatPatient;
import com.erojas.model.DetailConsultation;
import com.erojas.model.Doctor;
import com.erojas.model.MedicalConsultation;
import com.erojas.model.Patient;
import com.erojas.service.DetailConsultationService;
import com.erojas.service.DoctorService;
import com.erojas.service.MedicalConsultationService;
import com.erojas.service.PatientService;

@Controller
@RequestMapping("/treatPatientController")
public class TreatPatientController {
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private PatientService patientService;
	@Autowired
	private MedicalConsultationService medicalConsultationService;
	@Autowired
	private DetailConsultationService detailConsultationService;

	@RequestMapping(path = "/edit/{id}")
	public String treatPatientController(Model model, @PathVariable(value = "id") Integer id) {
		TreatPatient treatPatient = new TreatPatient();
		if (id == 0) {
			treatPatient.setId(detailConsultationService.generateId());
			model.addAttribute("listDoctor", doctorService.findAll());
			model.addAttribute("listPatient", patientService.findAll());
		}
		return "treatPatient_form";
	}

	@RequestMapping(path = "/save")
	public String save(Model model, @RequestParam(value = "idDoctor") Integer idDoctor,
			@RequestParam(value = "idPatient") Integer idPatient,
			@RequestParam(value = "dateMedical") String dateMedical,
			@RequestParam(value = "diagnosticConsultation") String diagnosticConsultation,
			@RequestParam(value = "treatmentConsultation") String treatmentConsultation) throws ParseException {


		DetailConsultation detailConsultation = new DetailConsultation();
		detailConsultation.setId(detailConsultationService.generateId());
		detailConsultation.setDiagnostic(diagnosticConsultation);
		detailConsultation.setTreatment(treatmentConsultation);
		List<DetailConsultation> listDetailConsultations =new ArrayList<DetailConsultation>();
		listDetailConsultations.add(detailConsultation);

		
		MedicalConsultation medicalConsultation = new MedicalConsultation();

		Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(dateMedical);
		LocalDate date2 = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		medicalConsultation.setId(medicalConsultationService.generateId());
		medicalConsultation.setDate(date2);
		medicalConsultation.addDetailConsultation(detailConsultation);
		List<MedicalConsultation> listMedicalConsultation = new ArrayList<MedicalConsultation>();
		listMedicalConsultation.add(medicalConsultation);
		
		Doctor doctor = doctorService.findById(idDoctor).get();
		Patient patient = patientService.findById(idPatient).get();
		
		doctor.addMedicalConsultation(medicalConsultation);
		patient.addMedicalConsultation(medicalConsultation);
		
		patientService.save(patient);
		doctorService.save(doctor);

		return findAll(model);
	}

	@RequestMapping(path = "/findAll")
	public String findAll(Model model) {
		model.addAttribute("list", patientService.findAllTreatPatients());
		return "treatPatient_list";
	}
}
