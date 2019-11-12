package com.erojas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erojas.repository.DetailConsultationRepository;
import com.erojas.service.DetailConsultationService;
@Service
public class DetailConsultationServiceImpl implements DetailConsultationService{
	@Autowired
	private DetailConsultationRepository detailConsultationRepository;

	@Override
	public Optional<com.erojas.model.DetailConsultation> findById(long id) {
		return detailConsultationRepository.findById(id);
	}

	@Override
	public void save(com.erojas.model.DetailConsultation entity) {
		detailConsultationRepository.save(entity);
	}

	@Override
	public void update(com.erojas.model.DetailConsultation entity) {
		detailConsultationRepository.save(entity);
	}

	@Override
	public void deleteById(long id) {
		detailConsultationRepository.deleteById(id);
	}

	@Override
	public List<com.erojas.model.DetailConsultation> findAll() {
		return (List<com.erojas.model.DetailConsultation>)detailConsultationRepository.findAll();
	}

	@Override
	public void deleteAll() {
		detailConsultationRepository.deleteAll();
	}

	@Override
	public boolean isUserExist(long id) {
		return findById(id).isPresent();
	}

	@Override
	public List<com.erojas.model.DetailConsultation> findDetailConsultationsByMedicalConsultationId(Long id) {
		return detailConsultationRepository.findDetailConsultationsByMedicalConsultationId(id);
	}

	@Override
	public Long generateId() {
		if(detailConsultationRepository.generateId()==null) {
			return 1L;
		}
		return detailConsultationRepository.generateId();
	}

	
	



}
