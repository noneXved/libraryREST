package com.bibliotekarze.libraryrest.service;

import com.bibliotekarze.libraryrest.dao.ReviewRepository;
import com.bibliotekarze.libraryrest.entity.Review;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ReviewServiceImplementation implements ReviewService{

    private final ReviewRepository reviewRepository;

    public ReviewServiceImplementation(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review findById(int theId) {
        Optional<Review> result = reviewRepository.findById(theId);

        Review theReview;

        if (result.isPresent()) {
            theReview = result.get();
        } else {
            throw new RuntimeException("Did not find review id - " + theId);
        }

        return theReview;
    }

    @Override
    public void save(Review theReview) {
        reviewRepository.save(theReview);
    }

    @Override
    public void deleteById(int theId) {
        reviewRepository.deleteById(theId);
    }
}
