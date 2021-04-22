package com.practice.test.controller;

import com.practice.test.domain.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/test")
    public Test testTest() {
        Test test = new Test();
        test.setId(1L);
        test.setUsername("testName");

        return test;
    }
}
