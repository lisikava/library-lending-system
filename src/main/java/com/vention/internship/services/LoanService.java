package com.vention.internship.services;

import com.vention.internship.models.Book;
import com.vention.internship.models.Loan;
import com.vention.internship.models.LoanStatus;
import com.vention.internship.models.Member;
import com.vention.internship.repositories.BookRepository;
import com.vention.internship.repositories.LoanRepository;
import com.vention.internship.repositories.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class LoanService {
    @Autowired
    private LoanRepository loanRepository;
    private BookRepository bookRepository;
    private MemberRepository memberRepository;
    public LoanService(LoanRepository loanRepository, BookRepository bookRepository, MemberRepository memberRepository) {
        this.loanRepository = loanRepository;
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
    }
    public List<Loan> findAll() {
        return loanRepository.findAll();
    }
    public Loan findById(Long id) {
        return loanRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Loan not found"));
    }
    public void delete(Long id) {
        if (!loanRepository.existsById(id))
            throw new NoSuchElementException("Loan not found");
        loanRepository.deleteById(id);
    }
    @Transactional
    public Loan lendBook(Long bookId, Long memberId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new NoSuchElementException("Book not found"));
        if (book.getAvailableCopies() < 1) {
            throw new NoSuchElementException("No copies available");
        }
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new NoSuchElementException("Member not found"));
        if (!member.isActive())
            throw new NoSuchElementException("Member not active");
        book.decreaseAvailableCopies();
        bookRepository.save(book);
        Loan loan = new Loan(book, member);
        return loanRepository.save(loan);
    }
    @Transactional
    public Loan returnBook(Long loanId) {
        Loan loan = loanRepository.findById(loanId).orElseThrow(() -> new NoSuchElementException("Book not found"));
        if (loan.getStatus() == LoanStatus.RETURNED)
            throw new NoSuchElementException("Book already returned");
        loan.setReturnDate(LocalDateTime.now());
        loan.setStatus(LoanStatus.RETURNED);
        loanRepository.save(loan);
        Book book = loan.getBook();
        book.increaseAvailableCopies();
        bookRepository.save(book);
        return loan;
    }

}
