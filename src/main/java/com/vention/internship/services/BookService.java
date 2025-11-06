package com.vention.internship.services;

import com.vention.internship.models.Author;
import com.vention.internship.models.Book;
import com.vention.internship.repositories.AuthorRepository;
import com.vention.internship.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }
    public Book create(Book book) {
        Author author = authorRepository.findById(book.getAuthor().getId())
                .orElseThrow(() -> new NoSuchElementException("Author not found"));
        book.setAuthor(author);
        book.setAvailableCopies(book.getTotalCopies());
        return bookRepository.save(book);
    }
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
    public Book findById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Book not found"));
    }
    public Book update(Long id, Book newBook) {
        Book book = findById(id);
        book.setTitle(newBook.getTitle());
        book.setIsbn(newBook.getIsbn());
        if (newBook.getAuthor() != null) {
            Author author = authorRepository.findById(newBook.getAuthor().getId())
                    .orElseThrow(() -> new NoSuchElementException("Author not found"));
            book.setAuthor(author);
        }
        book.setAvailableCopies(newBook.getAvailableCopies());
        book.setTotalCopies(newBook.getTotalCopies());
        return bookRepository.save(book);
    }
    public void delete(Long id) {
        if (!bookRepository.existsById(id))
            throw new NoSuchElementException("Book not found");
        bookRepository.deleteById(id);
    }
}
