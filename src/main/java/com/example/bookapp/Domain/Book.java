package com.example.bookapp.Domain;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "book", schema = "book_db")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;
    private int publicationDate;
    private String review;
    private int rating;

    @CreationTimestamp
    Date created_at;

    @UpdateTimestamp
    Date updated_at;

    public Book(Long id, String title, String author, int publicationDate, String review, int rating){
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.review = review;
        this.rating = rating;
    }

    public Book() {

    }

    public Long getId() {return id;}
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationDate() {
        return publicationDate;
    }
    public void setPublicationDate(int publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getReview() {
        return review;
    }
    public void setReview(String review) {this.review = review;}

    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
}
