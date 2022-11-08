package com.payment.demo.service.DirectPaymentService;

import com.payment.demo.clients.model.response.PaymentMethod;
import com.payment.demo.clients.model.response.ResponsePayment;
import com.payment.demo.controller.PaymentDirect.dto.request.RequestPaymentDto;

import java.util.List;

public interface PaymentService {
    public ResponsePayment payWithCardToken(RequestPaymentDto requestDto);
    public ResponsePayment payWithCardInfo(RequestPaymentDto dto);
}
