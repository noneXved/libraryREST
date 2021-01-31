package com.bibliotekarze.libraryrest.service;

import com.bibliotekarze.libraryrest.entity.Review;

import java.util.List;

public interface ReviewService {
    List<Review> findAll();

    Review findById(int theId);

    void save(Review theReview);

    void deleteById(int theId);

    List<Review> findReviewsByUserId(int userId);
}
