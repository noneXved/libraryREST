package com.bibliotekarze.libraryrest.rest;


import com.bibliotekarze.libraryrest.entity.Book;
import com.bibliotekarze.libraryrest.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService theBookService) {
        this.bookService = theBookService;
    }

    @GetMapping("/books")
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/books/{bookId}")
    public Book getBook(@PathVariable int bookId) {
        Book theBook = bookService.findById(bookId);

        if (theBook == null) {
            throw new RuntimeException("Book with id " + bookId + " not found.");
        }

        return theBook;
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book theBook) {

        theBook.setId(0);
        bookService.save(theBook);

        return theBook;
    }

    @PutMapping("/books")
    public Book updateBook(@RequestBody Book theBook) {
        bookService.save(theBook);

        return theBook;
    }

    @DeleteMapping("/books/{bookId}")
    public String deleteBook(@PathVariable int bookId) {

        Book theBook = bookService.findById(bookId);
        if (theBook == null) {
            throw new RuntimeException("Book with id " + bookId + " not found");
        }

        bookService.deleteById(bookId);

        return "Book with id " + bookId + " is deleted.";
    }

}
