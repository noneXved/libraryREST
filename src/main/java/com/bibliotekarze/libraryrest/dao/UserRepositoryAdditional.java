package com.bibliotekarze.libraryrest.dao;

import com.bibliotekarze.libraryrest.entity.User;
import com.bibliotekarze.libraryrest.exceptions.EAuthException;

public interface UserRepositoryAdditional {
    Integer create(String firstName, String lastName, String email, String nickname, String password) throws EAuthException;

    User findByEmailAndPassword(String email, String password) throws EAuthException;

    Integer getCountByEmail(String email);

}
