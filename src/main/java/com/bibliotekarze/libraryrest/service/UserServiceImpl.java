package com.bibliotekarze.libraryrest.service;

import com.bibliotekarze.libraryrest.dao.UserRepository;
import com.bibliotekarze.libraryrest.entity.User;
import com.bibliotekarze.libraryrest.exceptions.EAuthException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int theId) {
        Optional<User> result = userRepository.findById(theId);

        User theUser;

        if (result.isPresent()) {
            theUser = result.get();
        } else {
            throw new RuntimeException("Did not find user id - " + theId);
        }

        return theUser;
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
    public User validateUser(String nickname, String password) throws EAuthException {
        return null;
    }

    @Override
    public User registerUser(String firstName, String lastName, String email, String nickname, String password) throws EAuthException {
        // register by email
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if (email != null) {
            email = email.toLowerCase();
        }
        if (!pattern.matcher(email).matches()) {
            throw new EAuthException("Invalid email format");
        }
        Integer count = userRepository.getCountByEmail(email);
        if (count > 0) {
            throw new EAuthException("Email already in use");
        }

        Integer userId = userRepository.create(firstName, lastName, email, nickname, password);

        return findById(userId);
    }
}
