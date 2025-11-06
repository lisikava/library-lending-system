package com.vention.internship.services;

import com.vention.internship.models.Member;
import com.vention.internship.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    public Member create(Member member) {
        return memberRepository.save(member);
    }
    public List<Member> findAll() {
        return memberRepository.findAll();
    }
    public Member findById(Long id) {
        return memberRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Member not found"));
    }
    public Member update(Long id, Member newMember) {
        Member member = findById(id);
        member.setName(newMember.getName());
        member.setEmail(newMember.getEmail());
        member.setActive(newMember.isActive());
        return memberRepository.save(member);
    }
    public void delete(Long id) {
        if (!memberRepository.existsById(id))
            throw new NoSuchElementException("Member not found");
        memberRepository.deleteById(id);
    }
}
