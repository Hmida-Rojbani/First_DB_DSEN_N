package de.tekup.db.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.db.entities.Admin;
import de.tekup.db.entities.Matricule;
import de.tekup.db.services.AdminService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/admins")
public class AdminCtrl {
	
	private AdminService adminService;
	
	@PostMapping()
	public Admin saveAdmin(@RequestBody Admin admin) {
		return adminService.addAdmin(admin);
	}
	
	@GetMapping("/{id}")
	public Admin getOneAdmin(@PathVariable int id) {
		return adminService.getAdminById(id);
	}
	
	@PutMapping("/{id}/add/matricule")
	public Admin addMatricule(@PathVariable int id,
			@RequestBody Matricule matricule) {
		return adminService.addMatriculeToAdmin(id, matricule);
	}
	
	@GetMapping("/{id}/matricules")
	public List<Matricule> getMatriculesOfOneAdmin(@PathVariable int id) {
		return adminService.getAdminMatricules(id);
	}

}
