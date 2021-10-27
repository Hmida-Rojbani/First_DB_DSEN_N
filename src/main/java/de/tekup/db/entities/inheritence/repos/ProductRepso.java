package de.tekup.db.entities.inheritence.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.db.entities.inheritence.Product;

public interface ProductRepso extends JpaRepository<Product, Integer>{

}
