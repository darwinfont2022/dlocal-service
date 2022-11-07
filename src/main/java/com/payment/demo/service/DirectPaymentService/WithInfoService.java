package com.payment.demo.service.DirectPaymentService;

import com.payment.demo.clients.model.response.ResponsePayment;
import com.payment.demo.controller.PaymentDirect.dto.request.RequestPaymentCardInfoDto;

public interface WithInfoService {
    public ResponsePayment payWithCardInfo(RequestPaymentCardInfoDto requestDto);
}
