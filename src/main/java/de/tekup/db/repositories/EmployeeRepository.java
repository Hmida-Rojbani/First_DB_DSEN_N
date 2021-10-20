package de.tekup.db.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import de.tekup.db.entities.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer>{

	Optional<EmployeeEntity> findByName(String name);
	Optional<EmployeeEntity> findByNameIgnoreCase(String name);
	//SQL
	//@Query(value = "Select * from Employee where dob >= :date", nativeQuery = true)
	//JPQL
	@Query("Select e from EmployeeEntity e where e.dob >= :date")
	List<EmployeeEntity> bornAfter(@Param("date") LocalDate date);
}
