package com.erojas.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.erojas.model.Specialty;

@Repository
public interface SpecialtyRepository extends CrudRepository<Specialty,Long>{
	@Query("select max(s.id)+1 from Specialty s")
	public Long generateId();
}
