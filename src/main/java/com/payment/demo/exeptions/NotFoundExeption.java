package com.payment.demo.exeptions;

public class NotFoundExeption extends RuntimeException{
    private static final String DESCRIPTION = "Not found ";
    public NotFoundExeption(String msg){
        super(DESCRIPTION + msg);
    }
}

