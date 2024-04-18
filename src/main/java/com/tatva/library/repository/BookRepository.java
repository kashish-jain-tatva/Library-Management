package com.tatva.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tatva.library.entities.Book;

@Repository
public interface BookRepository  extends JpaRepository<Book, Integer>{

}
