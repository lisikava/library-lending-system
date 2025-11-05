package com.vention.internship.controllers;

import com.vention.internship.models.Book;
import com.vention.internship.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping
    public List<Book> findAll() {
        return bookService.findAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book book) {
        return bookService.create(book);
    }
    @GetMapping("/{id}")
    public Book get(@PathVariable Long id) {
        return bookService.findById(id);
    }
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book newBook) {
        return bookService.update(id, newBook);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }
}
