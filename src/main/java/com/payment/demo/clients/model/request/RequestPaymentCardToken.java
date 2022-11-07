package com.payment.demo.clients.model.request;

import com.payment.demo.clients.model.request.card.RequestCardToken;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestPaymentCardToken{
    private float amount;
    private String currency;
    private String country;
    private String payment_method_id;
    private String payment_method_flow;
    private Payer payer;
    private String order_id;
    private String notification_url;
    private String callback_url;

    private RequestCardToken card;
}
