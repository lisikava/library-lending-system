package com.vention.internship.repositories;

import com.vention.internship.models.Book;
import com.vention.internship.models.Loan;
import com.vention.internship.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByMember(Member member);
    List<Loan> findByBook(Book book);
}
