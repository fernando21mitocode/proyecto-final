package com.erojas.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "doctor")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	@Column(name = "dni",length = 8)
	private String dni;
	private String cmp;
	
	@ManyToOne
	@JoinColumn(name = "fk_specialty",nullable = false)
	private Specialty specialty;
	
	@OneToMany(mappedBy = "doctor",cascade = CascadeType.MERGE)
	private List<MedicalConsultation> medicalConsultations;
	
	public Doctor() {
		
	}
	
	
	public Doctor(Long id, String firstName, String lastName, String dni, String cmp) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dni = dni;
		this.cmp = cmp;
	
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getCmp() {
		return cmp;
	}
	public void setCmp(String cmp) {
		this.cmp = cmp;
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
		Doctor other = (Doctor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	public Specialty getSpecialty() {
		return specialty;
	}


	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}


	public List<MedicalConsultation> getMedicalConsultations() {
		return medicalConsultations;
	}


	public void setMedicalConsultations(List<MedicalConsultation> medicalConsultations) {
		this.medicalConsultations = medicalConsultations;
	}


	public String completeName() {
		StringBuilder sb = new StringBuilder();
		sb.append(firstName).append(" , ").append(lastName);
		return sb.toString();
	}
	
	public void addMedicalConsultation(MedicalConsultation medicalConsultation) {
		if(this.medicalConsultations == null) {
			this.medicalConsultations = new ArrayList<MedicalConsultation>();
		}
		this.medicalConsultations.add(medicalConsultation);
		medicalConsultation.setDoctor(this);
	}
}
