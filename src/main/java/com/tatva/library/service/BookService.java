package com.tatva.library.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tatva.library.entities.Book;
import com.tatva.library.exception.ResourceNotFoundException;
import com.tatva.library.repository.BookRepository;

@Service
public class BookService {

	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public Book createBook(Book book) {

		Book book2 = Book.builder().id(1).name("IKIGAI").build();
		bookRepository.save(book2);
		return book2;
	}

	public String checkIn(Book book) {
		Book book2 = findBookById(book.getId());
		LocalDateTime dateTime = LocalDateTime.now();
		book2.setCheckIn(dateTime);
		bookRepository.save(book);
		return "checked in!!";
	}

	
	public Book findBookById(int id) {
		Optional<Book> book = bookRepository.findById(id);
		if (book.isPresent()) {
			return book.get();
		} else {
			throw new ResourceNotFoundException("book not found");
		}
	}

	public String checkOut(int id) {
		Book book1 = findBookById(id);
		LocalDateTime dateTime = LocalDateTime.now();
		book1.setCheckOut(dateTime);
		return "checked Out!!";
	}
}
