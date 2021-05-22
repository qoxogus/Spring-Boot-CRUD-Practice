package com.practice.test.advice.exception;

public class UserLoginFailedException extends RuntimeException{
    public UserLoginFailedException (String msg, Throwable t){
        super(msg,t);
    }
    public UserLoginFailedException (String msg){
        super(msg);
    }
    public UserLoginFailedException(){
        super();
    }
}
