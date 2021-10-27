package de.tekup.db.entities.inheritence;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
// in case SingleTable
//@DiscriminatorValue("1")
//in case Joined
//@PrimaryKeyJoinColumn(name = "BookId")
public class Book extends Product{

	public Book(int id, String name, String author) {
		super(id, name);
		this.author = author;
	}

	private String author;
}
