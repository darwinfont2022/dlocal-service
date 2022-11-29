package com.payment.demo.clients.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseRefund {
    private String id;
    private String payment_id;
    private String notification_url;
    private String amount;
    private String currency;
    private String status;
    private String status_code;
    private String status_detail;
    private String created_date;
    private float amount_refunded;
}