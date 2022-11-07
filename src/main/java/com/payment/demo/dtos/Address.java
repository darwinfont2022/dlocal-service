package com.payment.demo.dtos;

public class Address {
    public String state ;
    public String city ;
    public String zip_code ;
    public String street ;
    public String number ;
    public Address() {
        this.state = "";
        this.city = "";
        this.zip_code = "";
        this.street = "";
        this.number = "";
    }
    public Address(String state, String city, String zip_code, String street, String number) {
        this.state = state;
        this.city = city;
        this. zip_code = zip_code;
        this.street = state;
        this.number = number;
    }
    public String toString() {
        return "{ state: " + state + ", city: " + city + ", zip_code: " + zip_code + ", street: " + street + ", number: " + number + "}";
    }
}
