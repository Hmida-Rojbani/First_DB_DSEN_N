package de.tekup.db.entities.inheritence;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
@AllArgsConstructor
@NoArgsConstructor
//@DiscriminatorColumn(name="product_type", 
//discriminatorType = DiscriminatorType.INTEGER)
public class Product {
	
	@Id
	private int id;
	private String name;

}
