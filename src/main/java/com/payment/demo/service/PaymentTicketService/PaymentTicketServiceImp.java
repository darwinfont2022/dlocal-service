package com.payment.demo.service.PaymentTicketService;

import com.payment.demo.clients.FeignClientDlocal;
import com.payment.demo.clients.model.request.Payer;
import com.payment.demo.clients.model.request.RequestPaymentRedirect;
import com.payment.demo.clients.model.response.ResponsePayment;
import com.payment.demo.controller.PaymentRedirect.dto.request.CreateRedirectPaymentDto;
import com.payment.demo.exeptions.ExceptionFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentTicketServiceImp implements PaymentTicketService {

    private final FeignClientDlocal dlocal;

    public PaymentTicketServiceImp(FeignClientDlocal dlocal) {
        this.dlocal = dlocal;
    }


    @Override
    public ResponsePayment createPaymentWithTicket(CreateRedirectPaymentDto paymentDto) {
        try {
            var paymentObj = RequestPaymentRedirect
                    .builder()
                    .payment_method_flow("REDIRECT")
                    .payment_method_id("AI")
                    .payer(Payer
                            .builder()
                            .name(paymentDto.getName())
                            .user_reference("")
                            .email(paymentDto.getEmail())
                            .document(paymentDto.getDocument())
                            .build()
                    )
                    .callback_url("http://payment/notification")
                    .notification_url("http://payment/notification")
                    .order_id(paymentDto.getOrder_id())
                    .amount(paymentDto.getAmount())
                    .currency(paymentDto.getCurrency())
                    .country(paymentDto.getCountry())
                    .build();
            return this.dlocal.createPayment(paymentObj);
        } catch (Exception e) {
            log.error("Error creating payment with ticket\n" + e.getMessage());

            throw new ExceptionFeignClient("Dlocal ticket creation failed");
        }
    }
}
