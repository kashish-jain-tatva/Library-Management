package com.tatva.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tatva.library.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
