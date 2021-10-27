package de.tekup.db.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import de.tekup.db.entities.Admin;
import de.tekup.db.entities.Matricule;
import de.tekup.db.repositories.AdminRepository;
import de.tekup.db.repositories.MatriculeRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AdminService {
	
	private AdminRepository adminRepository;
	private MatriculeRepository matRepository;
	
	public Admin addAdmin(Admin admin) {
		return adminRepository.save(admin);
	}
	
	public Admin getAdminById(int id) {
		return adminRepository.findById(id)
				.orElseThrow(()->new NoSuchElementException("Admin not found"));
	}
	
	public Admin addMatriculeToAdmin(int id, Matricule matricule) {
		Admin admin = getAdminById(id);
		matricule.setCreator(admin);
		matRepository.save(matricule);
		return admin;
	}
	
	public List<Matricule> getAdminMatricules(int adminId){
		Admin admin = getAdminById(adminId);
		return admin.getMatricules();
	}

}
