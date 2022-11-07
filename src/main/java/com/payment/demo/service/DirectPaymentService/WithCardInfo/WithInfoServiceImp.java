package com.payment.demo.service.DirectPaymentService.WithCardInfo;

import com.payment.demo.clients.FeignClientDlocal;
import com.payment.demo.clients.model.request.Payer;
import com.payment.demo.clients.model.request.RequestPaymentCardInfo;
import com.payment.demo.clients.model.request.card.RequestCardInfo;
import com.payment.demo.clients.model.response.ResponsePayment;
import com.payment.demo.controller.PaymentDirect.dto.request.RequestPaymentCardInfoDto;
import com.payment.demo.service.DirectPaymentService.WithCardInfo.WithInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WithInfoServiceImp implements WithInfoService {

    private final FeignClientDlocal dlocal;

    public WithInfoServiceImp(FeignClientDlocal dlocal) {
        this.dlocal = dlocal;
    }


    @Override
    public ResponsePayment payWithCardInfo(RequestPaymentCardInfoDto requestDto) {
        RequestPaymentCardInfo paymentCardInfo;
        try {
        RequestCardInfo card = RequestCardInfo.build(
                requestDto.getHolder_name(),
                requestDto.getExpiration_month(),
                requestDto.getExpiration_year(),
                requestDto.getNumber(),
                requestDto.getCvv()
        );
        Payer payer = new Payer(requestDto.getHolder_name(), "", "");
        paymentCardInfo = RequestPaymentCardInfo.build(
                requestDto.getAmount(),
                requestDto.getCurrency(),
                requestDto.getCountry(),
                requestDto.getOrder_id(),
                requestDto.getMethod_id(),
                card,
                payer
                );
            var response = dlocal.createPaymentWithCardInfo(paymentCardInfo);
            log.info(response.toString());
            return response;
        } catch (Exception e) {
            log.error("Error creando objetos" + e.getMessage());
            return null;
        }
    }
}
