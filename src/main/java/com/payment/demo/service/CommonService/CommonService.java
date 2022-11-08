package com.payment.demo.service.CommonService;

import com.payment.demo.clients.model.response.ResponseOrder;
import com.payment.demo.clients.model.response.ResponsePayment;
import com.payment.demo.controller.CommonController.dto.OrderShipDto;

public interface CommonService {
    OrderShipDto getOrderById(String orderId);

    ResponseOrder getOrderDetail(String orderId);

    ResponsePayment getPaymentById(String id);

    ResponsePayment getPaymentDetails(String paymentId);
}
