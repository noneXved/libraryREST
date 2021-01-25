package com.bibliotekarze.libraryrest.dao;

import com.bibliotekarze.libraryrest.entity.User;

import java.util.List;

public interface UserDAO {

    List<User> findAll();

    User findById(int theId);

    void save(User theUser);

    void deleteById(int theId);

}
