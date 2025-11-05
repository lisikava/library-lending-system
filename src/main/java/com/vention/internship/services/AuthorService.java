package com.vention.internship.services;

import com.vention.internship.models.Author;
import com.vention.internship.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    public Author create(Author author) {
        return authorRepository.save(author);
    }
    public List<Author> findAll() {
        return authorRepository.findAll();
    }
    public Author findById(Long id) {
        return authorRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Author not found"));
    }
    public Author update(Long id, Author newAuthor) {
        Author author = findById(id);
        author.setName(newAuthor.getName());
        return authorRepository.save(author);
    }
    public void delete(Long id) {
        if (!authorRepository.existsById(id))
            throw new NoSuchElementException("Author not found");
        authorRepository.deleteById(id);
    }
}
