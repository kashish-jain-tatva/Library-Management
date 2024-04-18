package com.tatva.library.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class User {

	@Id
	private Long id ;
	
	private String userName ;
	
	@OneToMany
	private List<Book> books ;
}