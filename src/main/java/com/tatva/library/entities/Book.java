package com.tatva.library.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Book {
	
	@Id
	private Integer id;
	
	private String name;
	
	private Long quantity;

}
