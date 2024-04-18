package com.tatva.library.service;

import org.springframework.stereotype.Service;

import com.tatva.library.entities.Book;
import com.tatva.library.repository.BookRepository;

@Service
public class BookService {

	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	
	public Book createBook(Book book) {
		
		Book book2 = Book.builder().name("IKIGAI").build();
		bookRepository.save(book2);
		return book2;
	}


	public String checkIn(Book book) {
		
		return null;
	}

}
