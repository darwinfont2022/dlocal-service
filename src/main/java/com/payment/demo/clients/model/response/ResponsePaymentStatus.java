package com.payment.demo.clients.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponsePaymentStatus {
    private String id;
    private String status;
    private String status_detail;
    private int status_code;
}
