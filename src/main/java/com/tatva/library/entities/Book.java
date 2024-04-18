package com.tatva.library.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Book {
	
	@Id
	@Column(name="book_id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "check_in")
	private LocalDateTime checkIn ;
	
	@Column(name="check_out")
	private LocalDateTime checkOut ;

}
