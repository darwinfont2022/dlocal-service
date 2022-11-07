package com.payment.demo.clients.model.response;

import lombok.Data;

@Data
public class ResponseCard {
    private String holder_name;
    private int expiration_month;
    private int expiration_year;
    private String last4;
    private String brand;
}
/*
"card":{
        "holder_name": "Thiago Gabriel",
        "expiration_month": 10,
        "expiration_year": 2040,
        "last4": "1111",
        "brand": "VI"
    },
 */