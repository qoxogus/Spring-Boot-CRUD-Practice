package com.practice.test.controller;

import com.practice.test.domain.Member;
import com.practice.test.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/save")
    public Member saveMember(@RequestBody Member member) {
        return memberService.save(member);
    }
}
