package com.payment.demo.service.RedirectPaymentService;

import com.payment.demo.clients.model.response.ResponsePayment;
import com.payment.demo.controller.PaymentRedirect.dto.request.CreateRedirectPaymentDto;

public interface RedirectService {

    public ResponsePayment createPayment(CreateRedirectPaymentDto paymentDto);
    public ResponsePayment createBankTranference(CreateRedirectPaymentDto paymentDto);
    ResponsePayment createPaymentWithTicket(CreateRedirectPaymentDto paymentDto);
}
