package com.payment.demo.service.RedirectPaymentService;

import com.payment.demo.clients.FeignClientDlocal;
import com.payment.demo.clients.model.request.Payer;
import com.payment.demo.clients.model.response.ResponsePayment;
import com.payment.demo.controller.PaymentRedirect.dto.request.CreateRedirectPaymentDto;
import com.payment.demo.clients.model.request.RequestPaymentRedirect;
import com.payment.demo.exeptions.ExceptionFeignClient;
import com.payment.demo.exeptions.NotFoundExeption;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RedirectServiceImp implements RedirectService{
    private final FeignClientDlocal clientDlocal;

    @Value("${dlocal.notification_base_url}")
    private String notification_base_url;

    public RedirectServiceImp(FeignClientDlocal clientDlocal) {
        this.clientDlocal = clientDlocal;
    }
    @Override
    public ResponsePayment createPayment(CreateRedirectPaymentDto paymentDto) {
        try {
            var payer = Payer
                    .builder()
                    .name(paymentDto.getName())
                    .user_reference(paymentDto.getUser_reference())
                    .email(paymentDto.getEmail())
                    .build();
            var paymentObj = RequestPaymentRedirect
                    .builder()
                    .amount(paymentDto.getAmount())
                    .country(paymentDto.getCountry())
                    .currency(paymentDto.getCurrency())
                    .order_id(paymentDto.getOrder_id())
                    .notification_url(notification_base_url)
                    .callback_url(notification_base_url)
                    .payment_method_flow("REDIRECT")
                    .payer(payer)
                    .build();

            return clientDlocal.createPayment(paymentObj);
        } catch (Exception e) {
            log.error("Error creating redirect payment\n\n" + e.getMessage());
            throw new ExceptionFeignClient("Dlocal enterprise");
        }
    }

    @Override
    public ResponsePayment createBankTranference(CreateRedirectPaymentDto paymentDto){
        try {
            var payer = Payer
                    .builder()
                    .name(paymentDto.getName())
                    .user_reference(paymentDto.getUser_reference())
                    .email(paymentDto.getEmail())
                    .document(paymentDto.getDocument())
                    .build();
            var paymentObj = RequestPaymentRedirect
                    .builder()
                    .amount(paymentDto.getAmount())
                    .country(paymentDto.getCountry())
                    .currency(paymentDto.getCurrency())
                    .order_id(paymentDto.getOrder_id())
                    .notification_url(notification_base_url)
                    .callback_url(notification_base_url)
                    .payment_method_id(paymentDto.getMethod_id())
                    .payment_method_flow("REDIRECT")
                    .payer(payer)
                    .build();

            return clientDlocal.createPayment(paymentObj);
        } catch (Exception e) {
            log.error("Error creating bank transference\n\n" + e.getMessage());
            throw new ExceptionFeignClient(" Dlocal enterprise error creating bank transference");
        }
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
            return this.clientDlocal.createPayment(paymentObj);
        } catch (Exception e) {
            log.error("Error creating payment with ticket\n" + e.getMessage());

            var i = e.getMessage().lastIndexOf("message");
            var m = e.getMessage().subSequence(i,e.getMessage().length() - 3).toString().replace("message\":\"", " ");

            throw new ExceptionFeignClient(m);
        }
    }
}
