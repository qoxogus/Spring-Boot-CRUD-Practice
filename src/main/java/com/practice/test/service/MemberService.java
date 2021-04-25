package com.practice.test.service;

import com.practice.test.domain.Member;
import com.practice.test.dto.MemberResponseDto;
import com.practice.test.dto.MemberSaveRequestDto;
import com.practice.test.dto.MemberUpdateRequestDto;
import com.practice.test.exception.UserAlreadyExistsException;
import com.practice.test.exception.UserNotFoundException;
import com.practice.test.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    //save
    public Long save(MemberSaveRequestDto requestDto) {
        //같은 이름의 회원이 있다면 회원가입X
        //name이 PK는 아닌데 id를 GeneratedValue로 지정해서 dto로 선언해놓지 않았기 때문에 이름으로 지정함
        if(memberRepository.findByName(requestDto.getName()) != null) {
            throw new UserAlreadyExistsException();
        }
        return memberRepository.save(requestDto.toEntity()).getId();
    }

    //read
    public MemberResponseDto findById(Long id) {
        Member entity = memberRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException());
        return new MemberResponseDto(entity); //id, name password
    }

    //update
    @Transactional
    public Long update(Long id, MemberUpdateRequestDto requestDto) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException());

        member.update(requestDto.getName(), requestDto.getPassword());
        return id;
    }

    //delete
    public void delete(Long id) {
        memberRepository.deleteById(id);
    }

    //login
    public Member login(String name) {
        Member member = memberRepository.findByName(name);
        if(member == null) throw new UserNotFoundException();
        return member;
    }
}
