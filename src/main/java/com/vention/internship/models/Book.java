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
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    @Column(name = "total_copies", nullable = false)
    private Integer totalCopies = 1;
    @Column(name = "available_copies", nullable = false)
    private Integer availableCopies = 1;
    public Book() {}
    public Book(String title, String isbn, Author author, Integer totalCopies, Integer availableCopies) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.totalCopies = totalCopies;
        this.availableCopies = availableCopies;
    }
    public Book(String title, String isbn, Author author) {
        this(title, isbn, author, 1, 1);
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
