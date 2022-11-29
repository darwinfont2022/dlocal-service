package com.payment.demo.clients;

import com.payment.demo.clients.model.request.RequestPaymentCardInfo;
import com.payment.demo.clients.model.request.RequestRefund;
import com.payment.demo.clients.model.response.*;
import com.payment.demo.clients.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="dlocalClient", url="${dlocal.api_url}", configuration = {FeignConfig.class})
public interface FeignClientDlocal {
    @PostMapping(value = "/payments", produces = "application/json")
    public ResponsePayment createPayment(@RequestBody Object body);

    @PostMapping(value = "/secure_payments", produces = "application/json")
    public ResponsePayment createPaymentWithCardInfo(@RequestBody RequestPaymentCardInfo body);

    @GetMapping(value = "/payments/{id}", produces = "application/json")
    public ResponsePayment getPaymentById(@PathVariable String id);

    @GetMapping(value = "/payments/{id}/status", produces = "application/json")
    public ResponsePaymentStatus getPaymentStatusById(@PathVariable String id);

    @GetMapping(value = "/payments-methods?country={country}")
    public List<PaymentMethod> getPaymentsMethods(@PathVariable String country);

    @GetMapping(value = "/currency-exchanges?from={from}&to={to}", produces = "application/json")
    public CurrencyExchange currencyExchanges(@PathVariable String from, @PathVariable String to);

   @GetMapping("/orders/{orderId}")
   public ResponseOrder getOrderById(@PathVariable String orderId);

   @PostMapping("/refunds")
    public ResponseRefund createRefunds(@RequestBody RequestRefund refund);

   @GetMapping("/refunds/{refundId}")
    public ResponseRefund getRefunds(@PathVariable String refundId);
}
