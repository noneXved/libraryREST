package com.bibliotekarze.libraryrest.dao;

import com.bibliotekarze.libraryrest.entity.Book;
import com.bibliotekarze.libraryrest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT book.title from user_book INNER JOIN book\n" +
            "ON user_book.book_id = book.id WHERE user_book.user_id = ?1", nativeQuery = true)
    List<String> getAllUserBooks(int userId);

}
