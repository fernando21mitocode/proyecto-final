package com.erojas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erojas.dto.DoctorSpecialty;
import com.erojas.model.Doctor;
import com.erojas.repository.DoctorRepository;
import com.erojas.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Override
	public Optional<Doctor> findById(long id) {
		return doctorRepository.findById(id);
	}

	@Override
	public void save(Doctor entity) {
		doctorRepository.save(entity);
	}

	@Override
	public void update(Doctor entity) {
		doctorRepository.save(entity);		
	}

	@Override
	public void deleteById(long id) {
		doctorRepository.deleteById(id);
	}

	@Override
	public List<Doctor> findAll() {
		return (List<Doctor>) doctorRepository.findAll();
	}

	@Override
	public void deleteAll() {
		doctorRepository.deleteAll();
	}

	@Override
	public boolean isUserExist(long id) {
		return findById(id).isPresent();
	}

	@Override
	public List<Doctor> findDoctorsBySpecialty(Long id) {
		return doctorRepository.findDoctorsBySpecialty(id);
	}

	@Override
	public Long generateId() {
		if(doctorRepository.generateId()==null) {
			return 1L;
		}
		return doctorRepository.generateId();
	}

	@Override
	public List<DoctorSpecialty> findAllOrderyBySpecialty() {
		return doctorRepository.findAllOrderyBySpecialty();
	}

}
