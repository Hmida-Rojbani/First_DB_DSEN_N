package de.tekup.db.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Table(name = "employee")
@Data
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="code")
public class EmployeeEntity extends Person{
	
	@Column(length = 70, nullable = false, unique = true)
	private String email;
	
	private LocalDate dob;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Matricule matricule;
	
	@ManyToMany(mappedBy = "employees")
	private List<Project> projects = new ArrayList<Project>();

}
