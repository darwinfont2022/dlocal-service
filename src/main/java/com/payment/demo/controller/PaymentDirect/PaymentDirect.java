package com.payment.demo.controller.PaymentDirect;

import com.payment.demo.clients.model.response.PaymentMethod;
import com.payment.demo.clients.model.response.ResponsePayment;
import com.payment.demo.controller.PaymentDirect.dto.request.RequestPaymentDto;
import com.payment.demo.clients.model.response.CurrencyExchange;
import com.payment.demo.service.DirectPaymentService.PaymentServiceImp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
@CrossOrigin(origins = "*")
public class PaymentDirect {
    private final PaymentServiceImp service;

    public PaymentDirect(PaymentServiceImp service){
        this.service = service;
    }

    @PostMapping("/payments/cardInfo")
    public ResponseEntity<ResponsePayment> paymentsWithCardInfo(@RequestBody RequestPaymentDto requestDto){
        return ResponseEntity.ok(this.service.payWithCardInfo(requestDto));
    }

    @PostMapping("/payments/cardToken")
    public ResponseEntity<ResponsePayment> paymentsWithCardToken(@RequestBody RequestPaymentDto dto){
        return ResponseEntity.ok(this.service.payWithCardToken(dto));
    }

    @PostMapping("/payments/cardSaved")
    public ResponseEntity<?> paymentsWithCardSaved(){
        return ResponseEntity.ok().build();
    }
}
