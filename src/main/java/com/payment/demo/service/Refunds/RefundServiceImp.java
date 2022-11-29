package com.payment.demo.service.Refunds;

import com.payment.demo.clients.FeignClientDlocal;
import com.payment.demo.clients.model.request.RequestRefund;
import com.payment.demo.clients.model.response.ResponseRefund;
import com.payment.demo.controller.Refunds.dto.RefundDtoIn;
import com.payment.demo.exeptions.ExceptionFeignClient;
import com.payment.demo.exeptions.NotFoundExeption;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RefundServiceImp implements RefreshService {

    private final FeignClientDlocal dlocal;

    @Value("${dlocal.notification_base_url}")
    private String notificationUrl;

    public RefundServiceImp(FeignClientDlocal dlocal) {
        this.dlocal = dlocal;
    }

    @Override
    public ResponseRefund createRefund(RefundDtoIn refund) {
        try {
            var request = RequestRefund
                    .builder()
                    .amount(refund.getAmount())
                    .currency(refund.getCurrency())
                    .payment_id(refund.getPayment_id())
                    .notification_url(this.notificationUrl)
                    .build();
            return dlocal.createRefunds(request);
        } catch (Exception e) {
            log.error("Failed to create refund" + e.getMessage());
            throw new ExceptionFeignClient("Failed to create refund");
        }
    }

    @Override
    public ResponseRefund getRefunds(String refundId) {
        try {
            return this.dlocal.getRefunds(refundId);
        } catch (Exception e) {
            log.error("Failed to get refund" + refundId);
            throw new NotFoundExeption("Refund " + refundId);
        }
    }
}
