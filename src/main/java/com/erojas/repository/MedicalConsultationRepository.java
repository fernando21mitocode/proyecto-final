package com.erojas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.erojas.model.MedicalConsultation;
@Repository
public interface MedicalConsultationRepository extends CrudRepository<MedicalConsultation, Long>{
	@Query("select new com.erojas.model.MedicalConsultation(m.id, m.date) from MedicalConsultation m"
			+ "  where m.doctor.id=m.id and m.id=:id")
	List<MedicalConsultation> findMedicalConsultationsByDoctorID(@Param("id") Long id);
	@Query("select new com.erojas.model.MedicalConsultation(m.id, m.date) from MedicalConsultation m "
			+ "  where m.patient.id = m.id and m.id= :id")
	List<MedicalConsultation> findMedicalConsultationsByPatientID(@Param("id") Long id);
	@Query("select max(m.id)+1 from MedicalConsultation m")
	public Long generateId();
}
