package de.tekup.db.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.tekup.db.entities.EmployeeEntity;
import de.tekup.db.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository empRepos;
	
	//SQL insert
	public EmployeeEntity saveEmpToDB(EmployeeEntity employeeEntity) {
		return empRepos.save(employeeEntity);
	}
	
	// Sql select * from employee
	public List<EmployeeEntity> getAllEmpFromDB() {
		return empRepos.findAll();
	}
	
	// SQL : select * from employee where id = id 
	public EmployeeEntity getEmployeeById(int id) {
		Optional<EmployeeEntity> opt =  empRepos.findById(id);
//		if(opt.isPresent())
//			return opt.get();
//		throw new NoSuchElementException("Employee with this id is not found");
		
		return opt
			.orElseThrow(()-> new NoSuchElementException("Employee with this id is not found"));
	}

}
