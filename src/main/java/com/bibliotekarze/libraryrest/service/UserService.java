package com.bibliotekarze.libraryrest.service;

import com.bibliotekarze.libraryrest.entity.Review;
import com.bibliotekarze.libraryrest.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    List<User> findAll();

    User findById(int theId);

    void save(User theUser);

    void deleteById(int theId);

    List<Review> findAllReviews(int userId);

}
