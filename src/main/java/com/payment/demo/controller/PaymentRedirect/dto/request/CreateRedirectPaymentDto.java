package com.payment.demo.controller.PaymentRedirect.dto.request;

import lombok.Data;

@Data
public class CreateRedirectPaymentDto {
    private String name;
    private String email;
    private String document;
    private String method_id;
    private String user_reference;// user_id
    private String order_id;
    private float amount;
    private String currency;
    private String country;
}
/*
 JSON request representation
{
    "name": "",
    "email": "",
    "user_reference": "",
    "order_id": "",
    "amount": "",
    "currency": "",
    "country": ""
}
 */