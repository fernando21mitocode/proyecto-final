package com.erojas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detail_consultation")
public class DetailConsultation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String diagnostic;
	private String treatment;
	
	@ManyToOne
	@JoinColumn(name = "fk_medical_consultation",nullable = false,updatable = false,insertable = true)
	private MedicalConsultation medicalConsultation;
	
	
	
	public DetailConsultation(Long id, String diagnostic, String treatment) {
		super();
		this.id = id;
		this.diagnostic = diagnostic;
		this.treatment = treatment;
	}

	public DetailConsultation() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDiagnostic() {
		return diagnostic;
	}

	public void setDiagnostic(String diagnostic) {
		this.diagnostic = diagnostic;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public MedicalConsultation getMedicalConsultation() {
		return medicalConsultation;
	}

	public void setMedicalConsultation(MedicalConsultation medicalConsultation) {
		this.medicalConsultation = medicalConsultation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetailConsultation other = (DetailConsultation) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
}
