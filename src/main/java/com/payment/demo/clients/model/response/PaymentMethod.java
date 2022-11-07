package com.payment.demo.clients.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentMethod {
    private String id;
    private String type;
    private String name;
    private String[] countries;
    private String logo;
    private String[] allowed_flows;
}
