package com.payment.demo.clients.model.request.card;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestCardToken {
    private String token;
}
