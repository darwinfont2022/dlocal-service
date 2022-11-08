package com.payment.demo.exeptions;

public class ExceptionFeignClient extends RuntimeException{
    private static final String DESCRIPTION = "Ups algo salio mal en la llamada a :";

    public ExceptionFeignClient(String message){
        super(DESCRIPTION + message);
    }
}
