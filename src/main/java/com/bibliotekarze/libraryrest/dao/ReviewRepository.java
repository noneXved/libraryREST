package com.bibliotekarze.libraryrest.dao;

import com.bibliotekarze.libraryrest.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
