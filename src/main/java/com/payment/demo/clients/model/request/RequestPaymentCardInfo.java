package com.payment.demo.clients.model.request;

import com.payment.demo.clients.model.request.card.RequestCardInfo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestPaymentCardInfo extends RequestPaymentRedirect{
    private RequestCardInfo card;

    public RequestPaymentCardInfo() {
        super();
    }

    public static RequestPaymentCardInfo build(float amount, String currency, String country, String order_id, String method_id, RequestCardInfo cardInfo, Payer payer) {
        var request = new RequestPaymentCardInfo();
        request.setAmount(amount);
        request.setCurrency(currency);
        request.setCountry(country);
        request.setOrder_id(order_id);
        request.setPayment_method_flow("DIRECT");
        request.setPayment_method_id(method_id);
        request.setPayer(payer);
        request.setCard(cardInfo);
        return request;
    }
}
