package com.dddn.exception;

public class DeptHasEmpsException extends RuntimeException{
    public DeptHasEmpsException(String errorMsg){
        super(errorMsg);
    }
}
