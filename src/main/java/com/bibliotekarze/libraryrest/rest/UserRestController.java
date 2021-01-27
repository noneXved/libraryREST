package com.bibliotekarze.libraryrest.rest;


import com.bibliotekarze.libraryrest.entity.User;
import com.bibliotekarze.libraryrest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @Autowired
    private final UserService userService;

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

    @PostMapping("/users/register")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody Map<String, Object> userMap) {
        String firstName = (String) userMap.get("firstName");
        String lastName = (String) userMap.get("lastName");
        String email = (String) userMap.get("email");
        String nickname = (String) userMap.get("nickname");
        String password = (String) userMap.get("password");
        User user = userService.registerUser(firstName, lastName, email, nickname, password);
        Map<String, String> map = new HashMap<>();
        map.put("message", "registered successfully");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}
