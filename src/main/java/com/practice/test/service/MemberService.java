package com.practice.test.service;

import com.practice.test.domain.Member;
import com.practice.test.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Transactional
    public Member save(Member member) {
        return memberRepository.save(member);
    }
}
