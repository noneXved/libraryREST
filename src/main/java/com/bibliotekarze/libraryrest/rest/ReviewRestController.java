package com.bibliotekarze.libraryrest.rest;

import com.bibliotekarze.libraryrest.entity.Review;
import com.bibliotekarze.libraryrest.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReviewRestController {

    private final ReviewService reviewService;

    public ReviewRestController(ReviewService theReviewService) {
        this.reviewService = theReviewService;
    }

    @GetMapping("/reviews")
    public List<Review> findAll() {
        return reviewService.findAll();
    }

    @GetMapping("/reviews/{reviewId}")
    public Review getReview(@PathVariable int reviewId) {
        Review theReview = reviewService.findById(reviewId);

        if (theReview == null) {
            throw new RuntimeException("Review with id " + reviewId + " not found.");
        }

        return theReview;
    }

    @PostMapping("/reviews")
    public Review addReview(@RequestBody Review theReview) {

        theReview.setId(0);
        reviewService.save(theReview);

        return theReview;
    }

    @PutMapping("/reviews")
    public Review updateReview(@RequestBody Review theReview) {
        reviewService.save(theReview);

        return theReview;
    }

    @DeleteMapping("/reviews/{reviewId}")
    public String deleteReview(@PathVariable int reviewId) {

        Review theReview = reviewService.findById(reviewId);
        if (theReview == null) {
            throw new RuntimeException("Review with id " + reviewId + " not found");
        }

        reviewService.deleteById(reviewId);

        return "Review with id " + reviewId + " is deleted.";
    }

}
