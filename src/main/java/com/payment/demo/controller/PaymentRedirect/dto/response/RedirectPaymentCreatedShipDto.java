package com.payment.demo.controller.PaymentRedirect.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RedirectPaymentCreatedShipDto {
    private String id;
    private String order_id;
    private String status;
}
