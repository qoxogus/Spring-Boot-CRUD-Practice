package com.practice.test.controller;

import com.practice.test.domain.Member;
import com.practice.test.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/save")
    public Member saveMember(@RequestBody Member member) {
        return memberService.save(member);
    }

    @GetMapping("/read")
    public List<Member> findAllMember() {
        List<Member> list = new ArrayList<>();
        Iterable<Member> iterable = memberService.findAll();
        for (Member member : iterable) {
            list.add(member);
        }
        return list;
    }

    @GetMapping("/read/{id}")
    public Optional<Member> findByMemberId(@PathVariable("id") Long id) {
        return memberService.findById(id);
    }
}
