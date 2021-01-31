package com.bibliotekarze.libraryrest.dao;

import com.bibliotekarze.libraryrest.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

    @Query(value = "SELECT * FROM reviews WHERE user_id =?1", nativeQuery = true)
    List<Review> findReviewsByUserId(int userId);
}
