package com.payment.demo.service.PaymentTicketService;

import com.payment.demo.clients.model.response.ResponsePayment;
import com.payment.demo.controller.PaymentRedirect.dto.request.CreateRedirectPaymentDto;

public interface PaymentTicketService {
    ResponsePayment createPaymentWithTicket(CreateRedirectPaymentDto paymentDto);
}
