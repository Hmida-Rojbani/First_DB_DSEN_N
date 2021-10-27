package de.tekup.db.services;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import de.tekup.db.entities.EmployeeEntity;
import de.tekup.db.entities.Project;
import de.tekup.db.repositories.EmployeeRepository;
import de.tekup.db.repositories.ProjectRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProjectService {
	
	private ProjectRepository projectRepository;
	
	private EmployeeService employeeService;
	
	public Project addProject(Project project) {
		return projectRepository.save(project);
	}
	
	public Project getProjectById(int id) {
		return projectRepository.findById(id)
						.orElseThrow(()-> new NoSuchElementException("Project not found"));
	}
	
	public Project addEmployeeToProject(
			int codeEmp,
			int projectId) {
		
		Project project = getProjectById(projectId);
		EmployeeEntity employeeEntity = employeeService.getEmployeeById(codeEmp);
		project.getEmployees().add(employeeEntity);
		projectRepository.save(project);
		return project;
	}

}
