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
public class RedirectServiceImp {
    private final FeignClientDlocal clientDlocal;

    @Value("${dlocal.notification_base_url}")
    private String notification_base_url;

    public RedirectServiceImp(FeignClientDlocal clientDlocal) {
        this.clientDlocal = clientDlocal;
    }

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

    public ResponsePayment getPaymentById(String id) {
        try {
            return clientDlocal.getPaymentById(id);
        } catch (Exception e) {
            log.error("Exception getting payment " + id + "\n\n" + e.getMessage());
            throw new NotFoundExeption("payment" + id);
        }
    }

    public ResponsePayment getPaymentDetails(String paymentId) {
        try {
            return clientDlocal.getPaymentById(paymentId);
        } catch (Exception e) {
            log.error("Exception getting payment " + paymentId + "\n\n" + e.getMessage());
            throw new NotFoundExeption("payment " + paymentId);
        }
    }
}
