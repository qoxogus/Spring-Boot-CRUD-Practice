package com.practice.test.dto;

import com.practice.test.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class MemberSaveRequestDto {

    private String name;
    private String password;

    public Member toEntity() {
        return Member.builder()
                .name(name)
                .password(password)
                .build();
    }
}
