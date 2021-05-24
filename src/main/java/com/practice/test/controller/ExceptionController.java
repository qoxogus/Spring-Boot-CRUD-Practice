package com.practice.test.controller;

import com.practice.test.advice.exception.UserAlreadyExistsException;
import com.practice.test.advice.exception.UserLoginFailedException;
import com.practice.test.advice.exception.UserNotFoundException;
import com.practice.test.respose.CommonResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/exception")
public class ExceptionController {

    @GetMapping(value = "/userNotFound")
    public CommonResult userNotFoundException() {
        throw new UserNotFoundException();
    }

    @GetMapping(value = "/userAlreadyExists")
    public CommonResult userAlreadyExistsException() {
        throw new UserAlreadyExistsException();
    }

    @GetMapping(value = "/userLoginFailed")
    public CommonResult userLoginFailedException(){
        throw new UserLoginFailedException();
    }
}
