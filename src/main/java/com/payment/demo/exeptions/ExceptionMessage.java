package com.payment.demo.exeptions;

import lombok.Data;

@Data
public class ExceptionMessage {
    private String exeptions;
    private String message;
    private String path;
    public ExceptionMessage(String exeptions, String message, String path) {
        this.exeptions = exeptions;
        this.message = message;
        this.path = path;
    }
}
