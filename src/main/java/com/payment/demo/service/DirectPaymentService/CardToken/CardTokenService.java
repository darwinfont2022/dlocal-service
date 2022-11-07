package com.payment.demo.service.DirectPaymentService.CardToken;

import com.payment.demo.clients.model.response.ResponsePayment;
import com.payment.demo.controller.PaymentDirect.dto.request.RequestPaymentCardTokenDto;

public interface CardTokenService {
    ResponsePayment createPaymentWithCardToken(RequestPaymentCardTokenDto dto);
}
