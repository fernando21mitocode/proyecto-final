package com.erojas.service;

import java.util.List;

import com.erojas.dto.TreatPatient;
import com.erojas.model.Patient;

public interface PatientService extends CRUD<Patient>{
	List<TreatPatient> findAllTreatPatients();
}
