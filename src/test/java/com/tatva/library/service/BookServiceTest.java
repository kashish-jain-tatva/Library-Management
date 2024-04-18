package com.tatva.library.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tatva.library.entities.Book;
import com.tatva.library.repository.BookRepository;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

	
	
	@InjectMocks
	private BookService bookService;
	
	@Mock
	private BookRepository bookRepository;

	private static Book book;

	@BeforeAll
	public static void setup() {
		book = Book.builder().name("IKIGAI").build();
	}

	@Test
	public void createBook() {
		when(bookRepository.save(book)).thenReturn(book);
		Book book1 = bookService.createBook(book);
		assertNotNull(book1);
		assertEquals("IKIGAI", "IKIGAI");
	}
	
	@Test
	public void checkinThrowsException() {
		
		Book book = null;
		assertThrows(NullPointerException.class,
	            ()->{
	            	bookService.checkIn(book);
	            });
	}
}
