package com.bibliotekarze.libraryrest.rest;

import com.bibliotekarze.libraryrest.entity.Review;
import com.bibliotekarze.libraryrest.service.ReviewService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReviewRestController {

    private final ReviewService reviewService;

    public ReviewRestController(ReviewService theReviewService) {
        this.reviewService = theReviewService;
    }

    @GetMapping(value = "/reviews",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
            )
    public List<Review> findAll() {
        return reviewService.findAll();
    }

    @GetMapping(value = "/reviews/{reviewId}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public Review getReview(@PathVariable int reviewId) {
        Review theReview = reviewService.findById(reviewId);

        if (theReview == null) {
            throw new RuntimeException("Review with id " + reviewId + " not found.");
        }

        return theReview;
    }

    @PostMapping(value = "/reviews",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public Review addReview(@RequestBody Review theReview) {

        theReview.setId(0);
        reviewService.save(theReview);

        return theReview;
    }

    @PutMapping(value = "/reviews",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public Review updateReview(@RequestBody Review theReview) {
        reviewService.save(theReview);

        return theReview;
    }

    @DeleteMapping(value = "/reviews/{reviewId}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public String deleteReview(@PathVariable int reviewId) {

        Review theReview = reviewService.findById(reviewId);
        if (theReview == null) {
            throw new RuntimeException("Review with id " + reviewId + " not found");
        }

        reviewService.deleteById(reviewId);

        return "Review with id " + reviewId + " is deleted.";
    }

}
