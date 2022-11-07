package com.payment.demo.clients;

import com.payment.demo.clients.model.request.RequestPaymentCardInfo;
import com.payment.demo.clients.model.request.RequestPaymentRedirect;
import com.payment.demo.clients.model.response.ResponsePayment;
import com.payment.demo.clients.config.FeignConfig;
import com.payment.demo.clients.model.response.ResponsePaymentStatus;
import com.payment.demo.dtos.CurrencyExchangeDto;
import com.payment.demo.clients.model.response.ResponseOrder;
import com.payment.demo.clients.model.response.PaymentMethod;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="dlocalClient", url="${dlocal.api_url}", configuration = {FeignConfig.class})
public interface FeignClientDlocal {
    /**
    Crear una solicitud de pago
    @params: PaymentBody
    @return: String con el cuerpo de la orden de pago formato json
     */
    @PostMapping(value = "/payments", produces = "application/json")
    public ResponsePayment createPayment(@RequestBody RequestPaymentRedirect body);

    @PostMapping(value = "/secure_payments", produces = "application/json")
    public ResponsePayment createPaymentWithCardInfo(@RequestBody RequestPaymentCardInfo body);

    /**
     * Obtener el estado de una orden
     * @param id
     * @return String object json
     */
    @GetMapping(value = "/payments/{id}", produces = "application/json")
    public ResponsePayment getPaymentById(@PathVariable String id);

    @GetMapping(value = "/payments/{id}/status", produces = "application/json")
    public ResponsePaymentStatus getPaymentStatusById(@PathVariable String id);
    /**
     * Obtener metodos de pagos dado un pais
     * @param country
     * @return Lista con los metodos de pago
     */
    @GetMapping(value = "/payments-methods?country={country}")
    public List<PaymentMethod> getPaymentsMethods(@PathVariable String country);

    @GetMapping(value = "/currency-exchanges?from={from}&to={to}", produces = "application/json")
    public CurrencyExchangeDto currencyExchanges(@PathVariable String from, @PathVariable String to);

   @GetMapping("/orders/{orderId}")
   public ResponseOrder getOrderById(@PathVariable String orderId);
}
