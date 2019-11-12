package com.erojas.service;

import java.util.List;

import com.erojas.dto.DoctorSpecialty;
import com.erojas.model.Doctor;

public interface DoctorService extends CRUD<Doctor>{
	List<Doctor> findDoctorsBySpecialty(Long id);
	List<DoctorSpecialty> findAllOrderyBySpecialty();


}
