package com.practice.test.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberUpdateRequestDto {

    private String name;
    private String password;

    @Builder
    public MemberUpdateRequestDto(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
