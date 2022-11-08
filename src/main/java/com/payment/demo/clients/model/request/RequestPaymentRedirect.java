package com.payment.demo.clients.model.request;

import com.payment.demo.controller.PaymentRedirect.dto.request.CreateRedirectPaymentDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RequestPaymentRedirect {
    private float amount;
    private String currency;
    private String country;
    private String payment_method_id = "";
    private String payment_method_flow = "REDIRECT";
    private Payer payer;
    private String order_id;
    private String notification_url;
    private String callback_url;
}
