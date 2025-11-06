package com.vention.internship.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "loans")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "book_id")
    private Book book;
    @ManyToOne(optional = false)
    @JoinColumn(name = "member_id")
    private Member member;
    @Column(nullable = false, name = "loan_date")
    private LocalDateTime loanDate = LocalDateTime.now();
    @Column(nullable = false, name = "due_date")
    private LocalDateTime dueDate;
    @Column(name = "return_date")
    private LocalDateTime returnDate;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "loan_status")
    private LoanStatus status;
    public Loan() {}
    public Loan(Book book, Member member, LocalDateTime loanDate, LocalDateTime dueDate, LocalDateTime returnDate, LoanStatus status) {
        this.book = book;
        this.member = member;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.status = status;
    }
    public Loan(Book book, Member member) {
        this(book, member, LocalDateTime.now(), LocalDateTime.now().plusMonths(1), null, LoanStatus.BORROWED);
    }
    public Long getId() {
        return id;
    }
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    public Member getMember() {
        return member;
    }
    public void setMember(Member member) {
        this.member = member;
    }
    public LocalDateTime getLoanDate() {
        return loanDate;
    }
    public void setLoanDate(LocalDateTime loanDate) {
        this.loanDate = loanDate;
    }
    public LocalDateTime getDueDate() {
        return dueDate;
    }
    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }
    public LocalDateTime getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }
    public LoanStatus getStatus() {
        return status;
    }
    public void setStatus(LoanStatus status) {
        this.status = status;
    }
}
