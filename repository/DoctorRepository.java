package com.erojas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.erojas.dto.DoctorSpecialty;
import com.erojas.model.Doctor;
@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long>{
	@Query("select new com.erojas.model.Doctor(d.id, d.firstName, d.lastName, d.dni, d.cmp) from"
			+ " Doctor d  where d.specialty.id =d.id and d.id=:id")
	List<Doctor> findDoctorsBySpecialty(@Param("id") Long id);
	@Query("select max(d.id)+1 from Doctor d")
	Long generateId();
	@Query("select new com.erojas.dto.DoctorSpecialty(d.id, d.firstName, d.lastName, d.dni, d.cmp,d.specialty.name) from"
			+ " Doctor d order by d.specialty.name asc")
	List<DoctorSpecialty> findAllOrderyBySpecialty();
}