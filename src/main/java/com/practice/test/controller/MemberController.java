package com.practice.test.controller;

import com.practice.test.domain.Member;
import com.practice.test.dto.MemberResponseDto;
import com.practice.test.dto.MemberSaveRequestDto;
import com.practice.test.dto.MemberUpdateRequestDto;
import com.practice.test.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/save")
    public Long saveMember(@RequestBody MemberSaveRequestDto requestDto) {
        return memberService.save(requestDto);
    }

    @GetMapping("/read/{id}")
    public MemberResponseDto findByMemberId(@PathVariable Long id) {
        return memberService.findById(id);
    }

    @PutMapping("/update/{id}")
    public Long update(@PathVariable Long id, @RequestBody MemberUpdateRequestDto requestDto) {
        return memberService.update(id, requestDto);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMember(@PathVariable Long id) {
        return memberService.delete(id);
    }

    @PostMapping("/login")
    public Member login(@RequestBody String name) {
        return memberService.login(name);
    }
}
