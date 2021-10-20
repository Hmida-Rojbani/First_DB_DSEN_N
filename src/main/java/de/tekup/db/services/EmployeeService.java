package de.tekup.db.services;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.tekup.db.entities.EmployeeEntity;
import de.tekup.db.entities.Matricule;
import de.tekup.db.repositories.EmployeeRepository;
import de.tekup.db.repositories.MatriculeRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeService {
	
	private EmployeeRepository empRepos;
	private MatriculeRepository matRepos;
	
	//SQL insert
	public EmployeeEntity saveEmpToDB(EmployeeEntity employeeEntity) {
//		Matricule matricule = employeeEntity.getMatricule();
//		matRepos.save(matricule);
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

	//SQL select * from Employee where name = name
	public EmployeeEntity getEmployeeByName(String name) {
		Optional<EmployeeEntity> opt =  empRepos.findByNameIgnoreCase(name);
		return opt
				.orElseThrow(()-> new NoSuchElementException("Employee with this name is not found"));
	}
	
	// Sql select * from employee where dob >= date
		public List<EmployeeEntity> getAllEmpFromDBWithDate(LocalDate date) {
			return empRepos.bornAfter(date);
		}
		
	//SQL : update 
		public EmployeeEntity updateEmployeeEntity(int id, EmployeeEntity newEntity)  {
			EmployeeEntity entity = getEmployeeById(id);
			
//			if(newEntity.getName()!=null)
//				entity.setName(newEntity.getName());
//			if(newEntity.getDob()!=null)
//				entity.setDob(newEntity.getDob());
//			if(newEntity.getEmail()!=null)
//				entity.setEmail(newEntity.getEmail());
			
			newEntity.setCode(entity.getCode());					
			BeanUtils.copyProperties(newEntity, entity, getNullFields(newEntity));
			
			return empRepos.save(entity);
			
		}
		
		//SQL : delete
		public EmployeeEntity deleteEmployeeById(int id) {
			EmployeeEntity entity = getEmployeeById(id);
			empRepos.deleteById(id);
			return entity;
		}
		
		// find null attributes in the received object
		private String[] getNullFields(EmployeeEntity newEntity) {
			ArrayList<String> strs = new ArrayList<String>();
			for (Field field : newEntity.getClass().getDeclaredFields()) {
		        field.setAccessible(true); // to allow the access of member attributes
		        Object attribute = null;
				try {
					attribute = field.get(newEntity);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					System.err.println(e.getMessage());
				} 
		        if (attribute == null) {
		            strs.add(field.getName());
		        }
		    }
			
			return strs.toArray(new String[0]);
		}
	

}
