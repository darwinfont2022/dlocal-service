package com.payment.demo.dtos;

import lombok.Data;

public class CurrencyExchangeDto {
    private String from;
    private String to;
    private String rete;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getRete() {
        return rete;
    }

    public void setRete(String rete) {
        this.rete = rete;
    }
}
