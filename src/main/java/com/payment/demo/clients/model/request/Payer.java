package com.payment.demo.clients.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payer {
    private String name;
    private String email;
    private String user_reference;
    public Payer(String name, String email, String user_reference) {
        this.name = name;
        this.email = email;
        this.user_reference = user_reference;
    }
}
