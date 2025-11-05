package com.vention.internship.models;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    private String isbn;
    @Column(name = "total_copies", nullable = false)
    private Integer totalCopies = 1;
    @Column(name = "available_copies", nullable = false)
    private Integer availableCopies = 1;
    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;
    public Book() {}
    public Book(String title, String isbn, Integer totalCopies, Integer availableCopies, Author author) {
        this.title = title;
        this.isbn = isbn;
        this.totalCopies = totalCopies;
        this.availableCopies = availableCopies;
        this.author = author;
    }
    public Book(String title, String isbn, Author author) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
    }
    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public Integer getTotalCopies() {
        return totalCopies;
    }
    public void setTotalCopies(Integer totalCopies) {
        this.totalCopies = totalCopies;
    }
    public void addCopy() {
        this.totalCopies += 1;
    }
    public int getAvailableCopies() {
        return availableCopies;
    }
    public void setAvailableCopies(Integer availableCopies) {
        this.availableCopies = availableCopies;
    }
    public void increaseAvailableCopies() {
        this.availableCopies += 1;
    }
    public void decreaseAvailableCopies() {
        this.availableCopies -= 1;
    }
    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }
}
