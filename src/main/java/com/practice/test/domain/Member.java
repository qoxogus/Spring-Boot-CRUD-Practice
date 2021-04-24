package com.practice.test.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    @Column(name = "member_name")
    private String name;
    @Column(name = "member_password")
    private String password;

    @Builder
    public Member(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    //Dirty check
    public void update(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
