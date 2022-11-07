package com.payment.demo.controller.PaymentDirect.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class RequestPaymentCardTokenDto {
    private float amount;
    private String currency;
    private String country;
    private String order_id;
    private String method_id;
    private String type;

    private String token;
}
