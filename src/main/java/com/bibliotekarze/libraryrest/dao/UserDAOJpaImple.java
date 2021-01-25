package com.bibliotekarze.libraryrest.dao;

import com.bibliotekarze.libraryrest.entity.User;
import org.hibernate.Session;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDAOJpaImple implements UserDAO{

    // define fiels for entityManager
    private EntityManager entityManager;

    // set up constructor
    public UserDAOJpaImple(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> findAll() {
        // get the current hib sessions
        Query theQuery = entityManager.createQuery("from User");

        List<User> users = theQuery.getResultList();

        return users;
    }

    @Override
    public User findById(int theId) {
        return entityManager.find(User.class, theId);
    }

    @Override
    public void save(User theUser) {

        User dbUser = entityManager.merge(theUser);
        theUser.setId(dbUser.getId());
    }

    @Override
    public void deleteById(int theId) {

        Query theQuery = entityManager.createQuery("delete from User where id=:userId");
        theQuery.setParameter("userId", theId);

        theQuery.executeUpdate();
    }
}
