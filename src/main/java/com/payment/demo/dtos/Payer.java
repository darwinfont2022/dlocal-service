package com.payment.demo.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payer {
    private String name;
    private String email;
    private String document;
    private String user_reference;
    private Address addresses;
    private String ip;
    private String device_id;

    public Payer(){
        this.name = "";
        this.email = "";
        this.document = "";
        this.user_reference = "";
        this.addresses = new Address();
        this.ip = "";
        this.device_id = "";
    }
    
    public Payer(String name, String email, String document, String user_reference, Address addresses, String ip) {
        this.name = name;
        this.email = email;
        this.document = document;
        this.user_reference = user_reference;
        this.addresses = addresses;
        this.ip = ip;
    }

    public String toString() {
        return "{ name: " + name + ", email: " + email + ", document:" + document + ", user_reference: " + user_reference + ", addresses: " + addresses.toString() + "ip: " + ip + "}";
    }
}
