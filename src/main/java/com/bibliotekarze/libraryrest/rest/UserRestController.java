package com.bibliotekarze.libraryrest.rest;


import com.bibliotekarze.libraryrest.entity.Book;
import com.bibliotekarze.libraryrest.entity.User;
import com.bibliotekarze.libraryrest.exception.UserErrorResponse;
import com.bibliotekarze.libraryrest.exception.UserNotFoundException;
import com.bibliotekarze.libraryrest.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService theUserService) {
        this.userService = theUserService;
    }

    @GetMapping(path = "/users",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping(value = "/users/{userId}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public User getUser(@PathVariable int userId) {
            return userService.findById(userId);
    }

    @GetMapping(value = "/users/{userId}/books",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<String> getAllUserBooks(@PathVariable int userId) {
            return userService.getAllUserBook(userId);
    }


    @PostMapping(value = "/users",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public User addUser(@RequestBody User theUser) {
        theUser.setId(0);
        userService.save(theUser);

        return theUser;
    }

    @PostMapping(value = "/users/register",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
            )
    public User registerUser(@RequestBody User theUser) {

        theUser.setId(0);
        userService.save(theUser);

        return theUser;
    }

    @PutMapping(value ="/users",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
            )
    public User updateUser(@RequestBody User theUser) {
        userService.save(theUser);

        return theUser;
    }

    @DeleteMapping(value = "/users/{userId}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public String deleteUser(@PathVariable int userId) {

        User theUser = userService.findById(userId);
        if (theUser == null) {
            throw new RuntimeException("User with id " + userId + " not found");
        }

        userService.deleteById(userId);

        return "User with id " + userId + " is deleted.";
    }

}
