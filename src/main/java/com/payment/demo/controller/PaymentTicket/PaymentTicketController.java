package com.payment.demo.controller.PaymentTicket;

import com.payment.demo.clients.model.response.ResponsePayment;
import com.payment.demo.controller.PaymentRedirect.dto.request.CreateRedirectPaymentDto;
import com.payment.demo.service.PaymentTicketService.PaymentTicketServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment-ticket")
public class PaymentTicketController {
    private final PaymentTicketServiceImp service;

    public PaymentTicketController(PaymentTicketServiceImp service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<ResponsePayment> createPaymetTycket(@RequestBody CreateRedirectPaymentDto dto) {
        return ResponseEntity.ok(this.service.createPaymentWithTicket(dto));
    }
}
