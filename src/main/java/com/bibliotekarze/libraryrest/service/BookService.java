package com.bibliotekarze.libraryrest.service;

import com.bibliotekarze.libraryrest.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    Book findById(int theId);

    void save(Book theBook);

    void deleteById(int theId);

}
