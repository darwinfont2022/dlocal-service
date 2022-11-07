package com.payment.demo.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter()
@Setter()
public class PaymentRequest {
    private String amount;
    private String currency;
    private String payment_method_id;
    private String payment_method_flow;
    private String country;
    private String order_id;
    private Payer payer;
    private CardDto card;
    private String notification_url;

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setPayment_method_id(String payment_method_id) {
        this.payment_method_id = payment_method_id;
    }

    public void setPayment_method_flow(String payment_method_flow) {
        this.payment_method_flow = payment_method_flow;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public void setPayer(Payer payer) {
        this.payer = payer;
    }

    public void setCard(CardDto card) {
        this.card = card;
    }

    public void setNotification_url(String notification_url) {
        this.notification_url = notification_url;
    }

    public PaymentRequest() {
        Payer payer = new Payer();
        CardDto card = new CardDto();
        this.amount = "";
        this.currency = "";
        this.country = "";
        this.payment_method_id = "";
        this.payment_method_flow = "";
        this.payer = payer;
        this.card = card;
        this.order_id = "657434343";
        this.notification_url = "https://2c9d-201-217-140-34.sa.ngrok.io/notificaciones";
    }

    @Override
    public String toString() {
        return "{ amount: " + amount + ", currency: " + currency + ", payment_method_id: " + payment_method_id + ", payment_method_flow: " + payment_method_flow + ", country: " + country + ", order_id: " + order_id + ", payer: " + payer.toString() + ", card: " + card.toString() + ", notification_url: " + notification_url + "}";
    }

    /**
     *
     * @return Un obj BodyRequest
     */
    public static PaymentRequest createBodyRequest(DataDto data){
        PaymentRequest body = new PaymentRequest();
        Address address = new Address(
            "Rio de Janeiro",
            "Volta Redonda",
            "27275-595",
            "Servidao B-1",
            "1106"
            );
        Payer payer = new Payer(
            "Thiago Gabriel",
            "thiago@example.com",
            "53033315550",
            "12345",
                address,
                data.ip
            );
        CardDto card = new CardDto(
//            "Thiago Gabriel",
//            "10",
//            "2040",
            data.token
            );
        body.setAmount("120.00");
        body.setCurrency("USD");
        body.setCountry("BR");
        body.setPayment_method_id("VD");
        body.setPayment_method_flow("DIRECT");
        body.setOrder_id("657434343");
        body.setNotification_url("https://bbf4-186-53-33-58.sa.ngrok.io/notificaciones");
        body.setPayer(payer);
        body.setCard(card);

        return body;
    }
}
