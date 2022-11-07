package com.payment.demo.controller.Order.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderShipDto {
    private String order_id;
    private String status;
    private String created_date;
}
