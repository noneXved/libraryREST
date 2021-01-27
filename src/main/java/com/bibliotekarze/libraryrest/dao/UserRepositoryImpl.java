package com.bibliotekarze.libraryrest.dao;

import com.bibliotekarze.libraryrest.entity.User;
import com.bibliotekarze.libraryrest.exceptions.EAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class UserRepositoryImpl implements UserRepositoryAdditional {

    private static final String SQL_CREATE = "INSERT INTO USER(ID, FIRST_NAME, LAST_NAME, EMAIL, NICKNAME, PASSWORD, IS_EMPLOYEE) VALUES (NULL, ?, ?, ?, ?, ?, 0)";
    private static final String SQL_COUNT_BY_EMAIL =  "SELECT COUNT(*) FROM user WHERE EMAIL = ?";
    private static final String SQL_FIND_BY_ID = "SELECT ID, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD " +
            "FROM USER WHERE ID = ?";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Integer create(String firstName, String lastName, String email, String nickname, String password) throws EAuthException{
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, firstName);
                ps.setString(2, lastName);
                ps.setString(3, email);
                ps.setString(4, nickname);
                ps.setString(5, password);
                return ps;
            }, keyHolder);
            return (Integer) keyHolder.getKeys().get("ID");
        } catch (Exception e) {
            throw new EAuthException("Invalid data. Failed to create account");
        }
    }

    @Override
    public User findByEmailAndPassword(String email, String password) throws EAuthException {
        return null;
    }

    @Override
    public Integer getCountByEmail(String email) {
        return jdbcTemplate.queryForObject(SQL_COUNT_BY_EMAIL, new Object[]{email}, Integer.class);
    }
}
