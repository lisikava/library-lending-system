package com.vention.internship.controllers;

import com.vention.internship.models.Loan;
import com.vention.internship.services.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {
    private LoanService loanService;
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }
    @GetMapping
    public List<Loan> findAll() {
        return loanService.findAll();
    }
    @GetMapping("/{id}")
    public Loan get(@PathVariable Long id) {
        return loanService.findById(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        loanService.delete(id);
    }
    @PostMapping("/lend")
    public ResponseEntity<Loan> lendBook(@RequestParam Long bookId, @RequestParam Long memberId) {
        Loan loan = loanService.lendBook(bookId, memberId);
        return ResponseEntity.ok(loan);
    }
    @PostMapping("{id}/return")
    public ResponseEntity<Loan> returnBook(@PathVariable Long id) {
        Loan loan = loanService.returnBook(id);
        return ResponseEntity.ok(loan);
    }

}
