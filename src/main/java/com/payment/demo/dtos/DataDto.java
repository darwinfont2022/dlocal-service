package com.payment.demo.dtos;

import lombok.NoArgsConstructor;


public class DataDto {
    public String token;
    public String ip;

    public DataDto() {
        this.token = "";
        this.ip = "";
    }
}
