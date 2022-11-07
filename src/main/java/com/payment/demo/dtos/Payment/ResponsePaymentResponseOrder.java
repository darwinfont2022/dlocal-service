package com.payment.demo.dtos.Payment;

import com.payment.demo.clients.model.response.ResponsePayment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponsePaymentResponseOrder extends ResponsePayment {
    private String payment_method_id;
    private String payment_method_flow;
    private  String created_date;
}
