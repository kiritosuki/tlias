package com.dddn.exception;

public class LoginErrorException extends RuntimeException{
    public LoginErrorException(String errorMsg){
        super(errorMsg);
    }
}
