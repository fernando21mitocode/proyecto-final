package com.erojas.dto;

import java.time.LocalDate;

public class TreatPatient {
	private Long id;
	private Long idDoctor;
	private String nameDoctor;
	private Long idPatient;
	private String namePatient;
	private String dateMedical;
	private LocalDate localDateMedical;
	private String diagnosticConsultation;
	private String treatmentConsultation;
	private String nameSpecialty;
	public TreatPatient() {}

	
	
	
	public TreatPatient(Long id, Long idDoctor, Long idPatient, String dateMedical, String diagnosticConsultation,
			String treatmentConsultation) {

		this.id = id;
		this.idDoctor = idDoctor;
		this.idPatient = idPatient;
		this.dateMedical = dateMedical;
		this.diagnosticConsultation = diagnosticConsultation;
		this.treatmentConsultation = treatmentConsultation;
	}




	public TreatPatient(Long id,  String nameDoctor,  String namePatient,
			LocalDate localDateMedical, String diagnosticConsultation, String treatmentConsultation) {
	
		this.id = id;
		
		this.nameDoctor = nameDoctor;
		
		this.namePatient = namePatient;
		this.localDateMedical= localDateMedical;
		this.diagnosticConsultation = diagnosticConsultation;
		this.treatmentConsultation = treatmentConsultation;
	}




	public LocalDate getLocalDateMedical() {
		return localDateMedical;
	}




	public void setLocalDateMedical(LocalDate localDateMedical) {
		this.localDateMedical = localDateMedical;
	}




	public String getNameDoctor() {
		return nameDoctor;
	}




	public void setNameDoctor(String nameDoctor) {
		this.nameDoctor = nameDoctor;
	}




	public String getNamePatient() {
		return namePatient;
	}




	public void setNamePatient(String namePatient) {
		this.namePatient = namePatient;
	}




	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(Long idDoctor) {
		this.idDoctor = idDoctor;
	}

	public Long getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(Long idPatient) {
		this.idPatient = idPatient;
	}

	public String getDateMedical() {
		return dateMedical;
	}

	public void setDateMedical(String dateMedical) {
		this.dateMedical = dateMedical;
	}

	public String getDiagnosticConsultation() {
		return diagnosticConsultation;
	}

	public void setDiagnosticConsultation(String diagnosticConsultation) {
		this.diagnosticConsultation = diagnosticConsultation;
	}

	public String getTreatmentConsultation() {
		return treatmentConsultation;
	}

	public void setTreatmentConsultation(String treatmentConsultation) {
		this.treatmentConsultation = treatmentConsultation;
	}




	public String getNameSpecialty() {
		return nameSpecialty;
	}




	public void setNameSpecialty(String nameSpecialty) {
		this.nameSpecialty = nameSpecialty;
	}
	

	


	
	
}
