package com.erojas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.erojas.dto.TreatPatient;
import com.erojas.model.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long>{
	@Query("select max(p.id)+1 from Patient p")
	public Long generateId();
	@Query("select new com.erojas.dto.TreatPatient(dc.id,d.firstName,p.firstName,mc.date,dc.diagnostic,dc.treatment) from Doctor d"
			+ "  ,MedicalConsultation mc"
			+ " ,Patient p"
			+ " ,DetailConsultation dc"
			+ " where d.id=mc.doctor.id and p.id=mc.patient.id"
			+ " and mc.id=dc.medicalConsultation.id")
	List<TreatPatient> findAllTreatPatients();
	
	

}
