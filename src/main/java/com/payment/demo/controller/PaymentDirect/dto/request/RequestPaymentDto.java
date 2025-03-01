package com.payment.demo.controller.PaymentDirect.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class RequestPaymentDto {
    private float amount;
    private String currency;
    private String country;
    private String order_id;
    private String method_id;
    private String type;

    private String holder_name;
    private String number;
    private String cvv;
    private int expiration_month;
    private int expiration_year;
    private String token;
}
