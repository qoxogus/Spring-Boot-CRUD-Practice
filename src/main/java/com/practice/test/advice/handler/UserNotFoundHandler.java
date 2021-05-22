package com.practice.test.advice.handler;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class UserNotFoundHandler {
    public void handle(HttpServletRequest request, HttpServletResponse response) throws IOException, SecurityException{
        response.sendRedirect("/exception/userNotFound");
    }
}
