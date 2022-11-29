package com.payment.demo.controller.Refunds.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RefundDtoIn {
    private String payment_id;
    private float amount;
    private String currency;
}
