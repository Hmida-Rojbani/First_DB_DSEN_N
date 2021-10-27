package de.tekup.db.entities.inheritence.repos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.db.entities.inheritence.Book;
import de.tekup.db.entities.inheritence.Pen;
import de.tekup.db.entities.inheritence.Product;

@RestController

public class ProductCtrl {
	
	@Autowired
	private ProductRepso productRepos;
	
	@GetMapping("/test/product")
	public List<Product> getAll(){
		
		Book book = new Book(1, "b1", "a1");
		productRepos.save(book);
		
		Pen pen = new Pen(2,"p1","c1");
		productRepos.save(pen);
		
		return productRepos.findAll();
	}

}
