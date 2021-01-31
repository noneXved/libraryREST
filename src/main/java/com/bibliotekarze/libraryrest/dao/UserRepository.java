package com.bibliotekarze.libraryrest.dao;

import com.bibliotekarze.libraryrest.entity.Review;
import com.bibliotekarze.libraryrest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

//    @Query("SELECT a FROM Author a WHERE firstName = ?1 AND lastName = ?2")
//    List<Author> findByFirstNameAndLastName(String firstName, String lastName);


}
