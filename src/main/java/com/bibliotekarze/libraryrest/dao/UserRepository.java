package com.bibliotekarze.libraryrest.dao;

import com.bibliotekarze.libraryrest.entity.User;
import com.bibliotekarze.libraryrest.exceptions.EAuthException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    Integer create(String firstName, String lastName, String email, String nickname, String password);

    User findByEmailAndPassword(String email, String password) throws EAuthException;

    Integer getCountByEmail(String email);

}
