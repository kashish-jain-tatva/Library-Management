package com.tatva.library.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Book {
	
	@Id
	private Integer id;
	
	private String name;
	
	private LocalDateTime checkIn ;
	
	private LocalDateTime checkOut ;

}
