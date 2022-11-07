package com.payment.demo.exeptions;

public class BadRequestException extends RuntimeException{
    private static final String DESCRIPTION = "Bad request Exception 400";
    public BadRequestException(String msg){
        super(DESCRIPTION + msg);
    }
}
