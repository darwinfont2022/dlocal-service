package com.payment.demo.service.RedirectPaymentService;

import com.payment.demo.clients.FeignClientDlocal;
import com.payment.demo.clients.model.response.ResponsePayment;
import com.payment.demo.controller.PaymentRedirect.dto.request.CreateRedirectPaymentDto;
import com.payment.demo.clients.model.request.RequestPaymentRedirect;
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

    public ResponsePayment createPayment(CreateRedirectPaymentDto createRedirectPaymentDto) {
        try {
            RequestPaymentRedirect paymentObj = RequestPaymentRedirect.buildRedirect(createRedirectPaymentDto, this.notification_base_url, "");//Creando payment Object
            return clientDlocal.createPayment(paymentObj);
        } catch (Exception e) {
            log.error("Error creating redirect payment\n\n" + e.getMessage());
            return  null;
        }
    }

    public ResponsePayment getPaymentById(String id) {
        try {
            return clientDlocal.getPaymentById(id);
        } catch (Exception e) {
            log.error("Exception getting payment " + id + "\n\n" + e.getMessage());
            return null;
        }
    }

    public ResponsePayment getPaymentDetails(String paymentId) {
        try {
            return clientDlocal.getPaymentById(paymentId);
        } catch (Exception e) {
            log.error("Exception getting payment " + paymentId + "\n\n" + e.getMessage());
            return null;
        }
    }
}
