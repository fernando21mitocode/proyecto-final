package com.erojas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.erojas.model.DetailConsultation;
@Repository
public interface DetailConsultationRepository extends CrudRepository<DetailConsultation, Long>{
	@Query("select new com.erojas.model.DetailConsultation(d.id, d.diagnostic, d.treatment) from DetailConsultation d "
			+ "   where d.medicalConsultation.id= d.id and d.id=:id")
	List<DetailConsultation> findDetailConsultationsByMedicalConsultationId(@Param("id") Long id);
	@Query("select max(d.id)+1 from DetailConsultation d")
	public Long generateId();
}
