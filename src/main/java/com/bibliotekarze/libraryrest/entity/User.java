package com.bibliotekarze.libraryrest.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private int enabled;

    @Column(name = "authority")
    private String authority;

//    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
//    @JoinTable(
//            name = "user_book",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "book_id")
//    )
//    private List<Book> books;

    public User(String firstName, String lastName, String email, String nickname, String password, int enabled, String authority) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.enabled = enabled;
        this.authority = authority;

    }


    @Override
    public String toString() {
        return "User" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled + " authority " + authority;
    }
}
