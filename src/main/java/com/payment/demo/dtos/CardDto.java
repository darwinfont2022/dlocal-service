package com.payment.demo.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardDto {
//    private String holder_name;
//    private String expiration_month;
//    private String expiration_year;
    // private String number;
    // private String cvv;
    private String token;
    public CardDto(){
//        this.holder_name = "";
//        this.expiration_month = "";
//        this.expiration_year = "";
        this.token = "";
    }
    public CardDto(String token) {
        //String holder_name, String expiration_month, String expiration_year,
        //this.holder_name = holder_name;//"Thiago Gabriel";
        //this.number = "4111111111111111";
        //this.cvv = "123";
        //this.expiration_month = expiration_month;//"10";
       // this.expiration_year = expiration_year;//"2040";
        this.token = token;
    }
    public String toString() {
        return "{  token: " + token + "}";//holder_name: " + holder_name + ", expiration_month: " + expiration_month + ", expiration_year: " + expiration_year + ",
    }
}
