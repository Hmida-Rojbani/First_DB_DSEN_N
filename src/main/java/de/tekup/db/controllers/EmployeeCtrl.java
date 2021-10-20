package de.tekup.db.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.db.entities.EmployeeEntity;
import de.tekup.db.services.EmployeeService;

@RestController
public class EmployeeCtrl {
	@Autowired
	private EmployeeService empService;
	
	@PostMapping("/employee/add")
	public EmployeeEntity addEmployee(@RequestBody EmployeeEntity employeeEntity) {
		return empService.saveEmpToDB(employeeEntity);
	}

	@GetMapping("/employee/get")
	public List<EmployeeEntity> getAllEmployee() {
		return empService.getAllEmpFromDB();
	}
	
	@GetMapping("/employee/get/{id}")
	public EmployeeEntity getOneEmployee(@PathVariable int id) {
		return empService.getEmployeeById(id);
	}
	

}
