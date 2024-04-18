package com.tatva.library.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class User {

	private Long id ;
	
	private String userName ;
	
	@OneToMany
	private List<Book> books ;
}