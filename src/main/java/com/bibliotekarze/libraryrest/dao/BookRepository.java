package com.bibliotekarze.libraryrest.dao;

import com.bibliotekarze.libraryrest.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
