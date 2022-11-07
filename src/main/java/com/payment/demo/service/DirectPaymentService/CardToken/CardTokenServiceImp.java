package com.payment.demo.service.DirectPaymentService.CardToken;

import com.payment.demo.clients.FeignClientDlocal;
import com.payment.demo.clients.model.request.Payer;
import com.payment.demo.clients.model.request.RequestPaymentCardToken;
import com.payment.demo.clients.model.request.card.RequestCardToken;
import com.payment.demo.clients.model.response.ResponsePayment;
import com.payment.demo.controller.PaymentDirect.dto.request.RequestPaymentCardTokenDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CardTokenServiceImp implements CardTokenService {
    private final FeignClientDlocal dlocal;

    public CardTokenServiceImp(FeignClientDlocal dlocal) {
        this.dlocal = dlocal;
    }


    @Override
    public ResponsePayment createPaymentWithCardToken(RequestPaymentCardTokenDto requestDto) {
        log.info("Dto recived \n",requestDto.toString());
        RequestPaymentCardToken payment = RequestPaymentCardToken.builder()
                .order_id(requestDto.getOrder_id())
                .amount(requestDto.getAmount())
                .currency(requestDto.getCurrency())
                .country(requestDto.getCountry())
                .payment_method_id(requestDto.getMethod_id())
                .payment_method_flow("DIRECT")
                .notification_url("https://localhost/url")
                .callback_url("https://localhost/callback_url")
                .payer(new Payer("", "", ""))
                .card(new RequestCardToken(requestDto.getToken()))
                .build();

        log.info("Payment Object created \n",payment.toString());

        try {
            return this.dlocal.createPayment(payment);
        } catch (Exception e) {
            log.error("Error calling dlocalClient");
            log.error(e.getMessage());
            return null;
        }
    }
}
