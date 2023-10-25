package com.service.util.exceptions;

public class InitializerException extends RuntimeException{
    //Exception for any builder
    public InitializerException(String message){
        super(message);
    }

    public InitializerException() {
        super();
    }
}
