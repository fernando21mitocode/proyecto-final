package com.erojas.service;

import java.util.List;

import com.erojas.model.MedicalConsultation;

public interface MedicalConsultationService extends CRUD<MedicalConsultation> {
	List<MedicalConsultation> findMedicalConsultationsByDoctorID(Long id);
	List<MedicalConsultation> findMedicalConsultationsByPatientID(Long id);


}
