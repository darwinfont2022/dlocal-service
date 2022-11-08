package com.payment.demo.clients.model.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Payer {
    private String name;
    private String email;
    private String user_reference;
    private String document;
}
