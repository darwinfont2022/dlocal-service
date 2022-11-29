package com.payment.demo.controller.Notification.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class NotificationDto {
    private String id;
    private String amount;
    private String status;
    private String status_detail;
    private String status_code;
    private String currency;
    private String payment_method_id;
    private String payment_method_type;
    private String payment_method_flow;
    private String order_id;
    private String notification_url;
    private String created_date;
    private PayerDto payer;
}
