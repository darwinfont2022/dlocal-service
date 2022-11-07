package com.payment.demo.clients.model.request.card;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
    public class RequestCardInfo {
    private String holder_name;
    private int expiration_month;
    private int expiration_year;
    private String number;
    private String cvv;



    public RequestCardInfo(){
        this.holder_name = "";
        this.expiration_month = 0;
        this.expiration_year = 0;
        this.number = "";
        this.cvv = "";
    }

    public static RequestCardInfo build(String holder_name, int expiration_month, int expiration_year, String number, String cvv){
        var request = new RequestCardInfo();
        request.setHolder_name(holder_name);
        request.setExpiration_month(expiration_month);
        request.setExpiration_year(expiration_year);
        request.setNumber(number);
        request.setCvv(cvv);
        return request;
    }
}
