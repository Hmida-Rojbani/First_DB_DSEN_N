package de.tekup.db.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	
	private String code;
	
	@ManyToMany
	@JoinTable(name = "affected_in",
	joinColumns = @JoinColumn(name="project"),
	inverseJoinColumns = @JoinColumn(name = "employee"))
	private List<EmployeeEntity> employees;

}
