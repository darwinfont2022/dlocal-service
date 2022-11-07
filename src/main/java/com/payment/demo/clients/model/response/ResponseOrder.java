package com.payment.demo.clients.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseOrder {
    private float amount;
    private String currency;
    private String status;
    private String status_code;
    private String status_detail;
    private String created_date;
    private String approved_date;
    private String order_id;
}
