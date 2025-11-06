package com.vention.internship.controllers;

import com.vention.internship.models.Author;
import com.vention.internship.services.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    private AuthorService authorService;
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    @GetMapping
    public List<Author> findAll() {
        return authorService.findAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author create(@RequestBody Author author) {
        return authorService.create(author);
    }

    @GetMapping("/{id}")
    public Author get(@PathVariable Long id) {
        return authorService.findById(id);
    }
    @PutMapping("/{id}")
    public Author update(@PathVariable Long id, @RequestBody Author newAuthor) {
        return authorService.update(id, newAuthor);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        authorService.delete(id);
    }

}
