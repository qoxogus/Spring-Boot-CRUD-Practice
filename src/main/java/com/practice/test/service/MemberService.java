package com.practice.test.service;

import com.practice.test.domain.Member;
import com.practice.test.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

//    public Member findOne(Long id) {
//        return memberRepository.findById(id)
//    }

    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);

    }

    public Member update(String reName) {
        Member member = new Member();
        member.setName(reName);
        Member updated = memberRepository.save(member);
        return updated;
    }

    public void delete(Long id) {
        memberRepository.deleteById(id);
    }

    @Transactional
    public Member save(Member member) {
        return memberRepository.save(member);
    }
}
