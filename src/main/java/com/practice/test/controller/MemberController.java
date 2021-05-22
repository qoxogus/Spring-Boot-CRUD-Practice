package com.practice.test.controller;

import com.practice.test.domain.Member;
import com.practice.test.dto.MemberResponseDto;
import com.practice.test.dto.MemberSaveRequestDto;
import com.practice.test.dto.MemberSignInDto;
import com.practice.test.dto.MemberUpdateRequestDto;
import com.practice.test.respose.CommonResult;
import com.practice.test.respose.ResponseService;
import com.practice.test.respose.SingleResult;
import com.practice.test.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final ResponseService responseService;

    @PostMapping("/save")
    public SingleResult<Long> saveMember(@RequestBody MemberSaveRequestDto requestDto) {
        return responseService.getSingleResult(memberService.save(requestDto));
    }

    @GetMapping("/read/{id}")
    public SingleResult<MemberResponseDto> findByMemberId(@PathVariable Long id) {
        return responseService.getSingleResult(memberService.findById(id));
    }

    @PutMapping("/update/{id}")
    public SingleResult<Long> update(@PathVariable Long id, @RequestBody MemberUpdateRequestDto requestDto) {
        return responseService.getSingleResult(memberService.update(id, requestDto));
    }

    @DeleteMapping("/delete/{id}")
    public CommonResult deleteMember(@PathVariable Long id) {
        return responseService.getSingleResult(memberService.delete(id));
    }

    @PostMapping("/login")
    public SingleResult<Map<String, String>> login (@Valid @RequestBody MemberSignInDto memberSignInDto){
        final Member member = memberService.login(memberSignInDto.getName());
        Map<String, String> map = new HashMap<>();
        return responseService.getSingleResult(map);
    }
}
