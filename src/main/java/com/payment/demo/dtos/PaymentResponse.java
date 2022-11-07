package com.payment.demo.dtos;

import lombok.Data;
import lombok.ToString;

@Data
public class PaymentResponse {
    private String amount;
    private String currency;
    private String payment_method_id;
    private String payment_method_flow;
    private String country;
    private CardResponse card;
    private String created_date;
    private String approved_date;
    private String status;
    private String status_code;
    private String status_detail;
    private String order_id;
    private String notification_url;
}
@Data
@ToString
class CardResponse {
    private String holder_name;
    private  String expiration_month;
    private String expiration_year;
    private String last4;
    private String brand;
}
