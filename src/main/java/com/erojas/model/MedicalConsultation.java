package com.erojas.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "medical_consultation")
public class MedicalConsultation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDate date;
	
	@ManyToOne
	@JoinColumn(name = "fk_doctor",nullable = false)
	private Doctor doctor;
	
	@ManyToOne
	@JoinColumn(name = "fk_patient",nullable = false)
	private Patient patient;
	
	@OneToMany(mappedBy = "medicalConsultation",cascade = CascadeType.ALL)
	private List<DetailConsultation> detailConsultations;
	
	
	
	public MedicalConsultation(Long id, LocalDate date) {
		
		this.id = id;
		this.date = date;
	}

	public MedicalConsultation() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public List<DetailConsultation> getDetailConsultations() {
		return detailConsultations;
	}

	public void setDetailConsultations(List<DetailConsultation> detailConsultations) {
		this.detailConsultations = detailConsultations;
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
		MedicalConsultation other = (MedicalConsultation) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public void addDetailConsultation(DetailConsultation detailConsultation) {
		if(this.detailConsultations == null) {
			this.detailConsultations = new ArrayList<DetailConsultation>();
		}
		this.detailConsultations.add(detailConsultation);
		detailConsultation.setMedicalConsultation(this);
	}
	
}
