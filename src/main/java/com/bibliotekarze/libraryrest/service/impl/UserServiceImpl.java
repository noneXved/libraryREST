package com.bibliotekarze.libraryrest.service.impl;

import com.bibliotekarze.libraryrest.dao.UserRepository;
import com.bibliotekarze.libraryrest.entity.Book;
import com.bibliotekarze.libraryrest.entity.Review;
import com.bibliotekarze.libraryrest.entity.User;
import com.bibliotekarze.libraryrest.exception.UserNotFoundException;
import com.bibliotekarze.libraryrest.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int theId) {
        return userRepository.findById(theId)
                             .orElseThrow(
                                     () -> new NoSuchElementException("Book with id - " + theId + "doesn't exist"));
    }

    @Override
    public void save(User theUser) {
        userRepository.save(theUser);
    }

    @Override
    public void deleteById(int theId) {
        userRepository.deleteById(theId);
    }


    @Override
    public List<Review> findAllReviews(int userId) {
        return null;
    }

    @Override
    public List<String> getAllUserBook(int userId) {
        return userRepository.getAllUserBooks(userId);
    }

}
