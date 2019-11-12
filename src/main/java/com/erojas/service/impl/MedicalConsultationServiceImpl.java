package com.erojas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erojas.model.MedicalConsultation;
import com.erojas.repository.MedicalConsultationRepository;
import com.erojas.service.MedicalConsultationService;

@Service
public class MedicalConsultationServiceImpl implements MedicalConsultationService{
	@Autowired
	private MedicalConsultationRepository medicalConsultationRepository;
	@Override
	public Optional<MedicalConsultation> findById(long id) {
		return medicalConsultationRepository.findById(id);
	}

	@Override
	public void save(MedicalConsultation entity) {
		medicalConsultationRepository.save(entity);
	}

	@Override
	public void update(MedicalConsultation entity) {
		medicalConsultationRepository.save(entity);		
	}

	@Override
	public void deleteById(long id) {
		medicalConsultationRepository.deleteById(id);
	}

	@Override
	public List<MedicalConsultation> findAll() {
		return (List<MedicalConsultation>)medicalConsultationRepository.findAll();
	}

	@Override
	public void deleteAll() {
		medicalConsultationRepository.deleteAll();
	}

	@Override
	public boolean isUserExist(long id) {
		return findById(id).isPresent();
	}

	@Override
	public List<MedicalConsultation> findMedicalConsultationsByDoctorID(Long id) {
		return medicalConsultationRepository.findMedicalConsultationsByDoctorID(id);
	}

	@Override
	public List<MedicalConsultation> findMedicalConsultationsByPatientID(Long id) {
		return medicalConsultationRepository.findMedicalConsultationsByPatientID(id);
	}

	@Override
	public Long generateId() {
		if(medicalConsultationRepository.generateId()==null) {
			return 1L;
		}
		return medicalConsultationRepository.generateId();
	}

}
