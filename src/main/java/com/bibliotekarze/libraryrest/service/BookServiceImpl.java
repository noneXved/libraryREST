package com.bibliotekarze.libraryrest.service;

import com.bibliotekarze.libraryrest.dao.BookRepository;
import com.bibliotekarze.libraryrest.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(int theId) {
        Optional<Book> result = bookRepository.findById(theId);

        Book theBook;

        if (result.isPresent()) {
            theBook = result.get();
        } else {
            throw new RuntimeException("Did not find book id - " + theId);
        }

        return theBook;

    }

    @Override
    public void save(Book theBook) {
        bookRepository.save(theBook);
    }

    @Override
    public void deleteById(int theId) {
        bookRepository.deleteById(theId);
    }

}
