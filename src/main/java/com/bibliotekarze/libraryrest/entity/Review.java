package com.bibliotekarze.libraryrest.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
@Getter
@Setter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "book_id")
    private int bookId;

    @Column(name = "review")
    private String text;

    @Override
    public String toString() {
        return "Review: " +
                "id=" + id +
                ", userId=" + userId +
                ", bookId=" + bookId +
                ", review='" + text;
    }

}
