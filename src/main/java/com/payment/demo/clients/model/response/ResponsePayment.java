package com.payment.demo.clients.model.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
@Data
public class ResponsePayment extends ResponseOrder {
    private String id;
    private String payment_method_id;
    private String payment_method_type;
    private String country;
    private String notification_url;
    private String redirect_url;
    private ResponseCard card;
}
