package com.bibliotekarze.libraryrest.service;

import com.bibliotekarze.libraryrest.dao.UserDAO;
import com.bibliotekarze.libraryrest.entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserDAO userDAO;

    public UserServiceImpl(@Qualifier("userDAOJpaImple") UserDAO theUserDAO) {
        this.userDAO = theUserDAO;
    }

    @Override
    @Transactional
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    @Transactional
    public User findById(int theId) {
        return userDAO.findById(theId);
    }

    @Override
    @Transactional
    public void save(User theUser) {
        userDAO.save(theUser);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        userDAO.deleteById(theId);
    }
}
