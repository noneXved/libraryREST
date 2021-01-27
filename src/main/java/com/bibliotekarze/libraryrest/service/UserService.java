package com.bibliotekarze.libraryrest.service;

import com.bibliotekarze.libraryrest.entity.User;
import com.bibliotekarze.libraryrest.exceptions.EAuthException;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(int theId);

    void save(User theUser);

    void deleteById(int theId);

    User validateUser(String nickname, String password) throws EAuthException;

    User registerUser(String firstName, String lastName, String email, String nickname, String password) throws EAuthException;



}
