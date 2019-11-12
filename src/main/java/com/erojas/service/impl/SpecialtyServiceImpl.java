package com.erojas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erojas.model.Specialty;
import com.erojas.repository.SpecialtyRepository;
import com.erojas.service.SpecialtyService;

@Service
public class SpecialtyServiceImpl implements SpecialtyService{
	@Autowired
	private SpecialtyRepository specialtyRepository;
	@Override
	public Optional<Specialty> findById(long id) {
		return specialtyRepository.findById(id);
	}

	@Override
	public void save(Specialty entity) {
		specialtyRepository.save(entity);
	}

	@Override
	public void update(Specialty entity) {
		specialtyRepository.save(entity);		
	}

	@Override
	public void deleteById(long id) {
		specialtyRepository.deleteById(id);
	}

	@Override
	public List<Specialty> findAll() {
		return (List<Specialty>) specialtyRepository.findAll();
	}

	@Override
	public void deleteAll() {
		specialtyRepository.deleteAll();
	}

	@Override
	public boolean isUserExist(long id) {
		return findById(id).isPresent();
	}

	@Override
	public Long generateId() {
		if(specialtyRepository.generateId() ==null) {
			return 1L;
		}
		return specialtyRepository.generateId();
	}

}
