package com.erojas.service;

import java.util.List;

import com.erojas.model.DetailConsultation;

public interface DetailConsultationService extends CRUD<DetailConsultation>{
	List<DetailConsultation> findDetailConsultationsByMedicalConsultationId( Long id);

}
