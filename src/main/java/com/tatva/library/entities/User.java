package com.tatva.library.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class User {

	@Id
	@Column(name = "user_id")
	private Long id ;
	
	@Column(name = "user_name")
	private String userName ;
	
	@OneToMany
	private List<Book> books ;
}