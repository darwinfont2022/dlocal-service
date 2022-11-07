package com.payment.demo.clients.model.request;

import com.payment.demo.controller.PaymentRedirect.dto.request.CreateRedirectPaymentDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RequestPaymentRedirect {
    private float amount;
    private String currency;
    private String country;
    private String payment_method_id;
    private String payment_method_flow;
    private Payer payer;
    private String order_id;
    private String notification_url;
    private String callback_url;

    public RequestPaymentRedirect(float amount, String currency, String country, Payer payer, String order_id, String notification_base_url, String callback_url){
        this.amount = amount;
        this.currency = currency;
        this.country = country;
        this.payment_method_flow = "REDIRECT";
        this.payer = payer;
        this.order_id = order_id;
        this.notification_url = notification_base_url + "/notifications";
        this.callback_url = callback_url;
    }

    public RequestPaymentRedirect(){
        this.amount = 0;
        this.currency = "";
        this.country = "";
        this.payment_method_flow = "";
        this.payer = null;
        this.order_id = "";
        this.notification_url = "";
        this.callback_url = "";
    }

    public static RequestPaymentRedirect buildRedirect(CreateRedirectPaymentDto frontDto, String notification_base_url, String callback_url){
        Payer payer = new Payer(frontDto.getName(), frontDto.getEmail(), frontDto.getUser_reference());
        RequestPaymentRedirect paymentObj = new RequestPaymentRedirect(
                frontDto.getAmount(),
                frontDto.getCurrency(),
                frontDto.getCountry(),
                payer,
                frontDto.getOrder_id(),
                notification_base_url,
                callback_url
        );

        return paymentObj;
    }
}
