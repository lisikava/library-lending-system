package com.vention.internship.controllers;

import com.vention.internship.models.Member;
import com.vention.internship.services.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {
    private MemberService memberService;
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    @GetMapping
    public List<Member> findAll() {
        return memberService.findAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Member create(@RequestBody Member member) {
        return memberService.create(member);
    }
    @GetMapping("/{id}")
    public Member get(@PathVariable Long id) {
        return memberService.findById(id);
    }
    @PutMapping("/{id}")
    public Member update(@PathVariable Long id, @RequestBody Member newMember) {
        return memberService.update(id, newMember);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        memberService.delete(id);
    }

}
