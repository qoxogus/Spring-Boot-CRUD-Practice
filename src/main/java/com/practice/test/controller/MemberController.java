package com.practice.test.controller;

import com.practice.test.domain.Member;
import com.practice.test.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

//    @PutMapping("/update/{name}")
//    public Member updateMember(@PathVariable("name") String name, @RequestBody String reName) {
//        return memberService.update(reName);
//    }

    @DeleteMapping("/delete/{id}")
    public void deleteMember(@PathVariable("id") Long id) {
        memberService.delete(id);
    }
}
