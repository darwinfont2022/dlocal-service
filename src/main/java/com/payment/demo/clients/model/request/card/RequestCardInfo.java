package com.payment.demo.clients.model.request.card;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
    public class RequestCardInfo {
    private String holder_name;
    private int expiration_month;
    private int expiration_year;
    private String number;
    private String cvv;
}
