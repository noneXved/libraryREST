package com.bibliotekarze.libraryrest.rest;


import com.bibliotekarze.libraryrest.entity.Review;
import com.bibliotekarze.libraryrest.service.ReviewService;
import com.bibliotekarze.libraryrest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users/{userId}/reviews")
public class UserReviewRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private ReviewService reviewService;


    @GetMapping("")
    public List<Review> getReviewsById(@PathVariable int userId) {
        return reviewService.findReviewsByUserId(userId);
    }

}
