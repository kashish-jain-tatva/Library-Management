package com.tatva.library.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tatva.library.entities.Book;
import com.tatva.library.exception.ResourceNotFoundException;
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
		book = Book.builder().id(1).name("IKIGAI").build();
	}

	@Test
	public void createBook() {
		when(bookRepository.save(book)).thenReturn(book);
		Book book1 = bookService.createBook(book);
		assertNotNull(book1);
		assertEquals("IKIGAI", book.getName());
	}

	@Test
	public void checkin() {
		Book book = Book.builder().id(2).name("IKIGAI").build();
		when(bookRepository.findById(anyInt())).thenReturn(Optional.of(book));
		String bookString = bookService.checkIn(book);
		assertEquals("checked in!!", bookString);
	}

	@Test
	public void checkInThrowsException() {
		when(bookRepository.findById(anyInt())).thenReturn(Optional.empty());
		assertThrows(ResourceNotFoundException.class, () -> {
			bookService.checkIn(book);
		});
	}

	@Test
	public void findBookByIdThrowsException() {
		assertThrows(ResourceNotFoundException.class, () -> {
			bookService.findBookById(0);
		});
	}
	
	@Test void checkOut() {
		Book book = Book.builder().id(2).name("IKIGAI").build();
		when(bookRepository.findById(anyInt())).thenReturn(Optional.of(book));
		String bookString = bookService.checkOut(anyInt());
		assertEquals("checked Out!!", bookString);
	}
	
	@Test
	public void checkOutThrowsException() {
		when(bookRepository.findById(anyInt())).thenReturn(Optional.empty());
		assertThrows(ResourceNotFoundException.class, () -> {
			bookService.checkOut(anyInt());
		});
	}
}
