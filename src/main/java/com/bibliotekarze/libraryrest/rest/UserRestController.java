package com.bibliotekarze.libraryrest.rest;


import com.bibliotekarze.libraryrest.entity.User;
import com.bibliotekarze.libraryrest.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {

    private UserService userService;

    public UserRestController(UserService theUserService) {
        this.userService = theUserService;
    }

    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable int userId) {
        User theUser = userService.findById(userId);

        if (theUser == null) {
            throw new RuntimeException("User with id " + userId + " not found.");
        }

        return theUser;
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User theUser) {

        theUser.setId(0);
        userService.save(theUser);

        return theUser;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User theUser) {
        userService.save(theUser);

        return theUser;
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable int userId) {

        User theUser = userService.findById(userId);
        if (theUser == null) {
            throw new RuntimeException("User with id " + userId + " not found");
        }

        userService.deleteById(userId);

        return "User with id " + userId + " is deleted.";
    }


//    @PostMapping()

}
