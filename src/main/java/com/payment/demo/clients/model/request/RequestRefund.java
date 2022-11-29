package com.payment.demo.clients.model.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RequestRefund {
    private String payment_id;
    private String notification_url;
    private float amount;
    private String currency;
}
