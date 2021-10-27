package de.tekup.db.entities.inheritence;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
//@DiscriminatorValue("2")
public class Pen extends Product {

	public Pen(int id, String name, String color) {
		super(id, name);
		this.color = color;
	}

	private String color;
}
