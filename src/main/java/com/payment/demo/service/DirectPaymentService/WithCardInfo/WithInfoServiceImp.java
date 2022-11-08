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
        try {
            RequestCardInfo card = RequestCardInfo
                .builder()
                .holder_name(requestDto.getHolder_name())
                .number(requestDto.getNumber())
                .cvv(requestDto.getCvv())
                .expiration_month(requestDto.getExpiration_month())
                .expiration_year(requestDto.getExpiration_year())
                .build();

            Payer payer = Payer
                .builder()
                .name(requestDto.getHolder_name())
                .email("")
                .user_reference("")
                .build();

            RequestPaymentCardInfo paymentCardInfo = RequestPaymentCardInfo
                .builder()
                .amount(requestDto.getAmount())
                .currency(requestDto.getCurrency())
                .country(requestDto.getCountry())
                .order_id(requestDto.getOrder_id())
                .payment_method_id(requestDto.getMethod_id())
                .payment_method_flow("DIRECT")
                .notification_url("")
                .callback_url("")
                .payer(payer)
                .card(card)
                .build();

            return dlocal.createPaymentWithCardInfo(paymentCardInfo);
        } catch (Exception e) {
            log.error("Error creando objetos" + e.getMessage());
            return null;
        }
    }
}
