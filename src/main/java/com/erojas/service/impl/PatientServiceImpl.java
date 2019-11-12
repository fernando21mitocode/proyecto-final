package com.erojas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erojas.dto.TreatPatient;
import com.erojas.model.Patient;
import com.erojas.repository.PatientRepository;
import com.erojas.service.PatientService;
@Service
public class PatientServiceImpl implements PatientService{
	@Autowired
	private PatientRepository patientRepository;
	@Override
	public Optional<Patient> findById(long id) {
		return patientRepository.findById(id);
	}

	@Override
	public void save(Patient entity) {
		patientRepository.save(entity);
	}

	@Override
	public void update(Patient entity) {
		patientRepository.save(entity);
	}

	@Override
	public void deleteById(long id) {
		patientRepository.deleteById(id);
	}

	@Override
	public List<Patient> findAll() {
		return (List<Patient>)patientRepository.findAll();
	}

	@Override
	public void deleteAll() {
		patientRepository.deleteAll();
	}

	@Override
	public boolean isUserExist(long id) {
		return findById(id).isPresent();
	}

	@Override
	public Long generateId() {
		if(patientRepository.generateId()==null) {
			return 1L;
		}
		return patientRepository.generateId();
	}

	@Override
	public List<TreatPatient> findAllTreatPatients() {
		return patientRepository.findAllTreatPatients();
	}

}
