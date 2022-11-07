package com.payment.demo.exeptions;

public class ExceptionFeignClient extends RuntimeException{
    private static final String DESCRIPTION = "Ups algo salio mal enla llamada a :";

    public ExceptionFeignClient(String message){
        super(DESCRIPTION + message);
    }
}
