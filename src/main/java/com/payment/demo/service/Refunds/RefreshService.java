package com.payment.demo.service.Refunds;

import com.payment.demo.clients.model.request.RequestRefund;
import com.payment.demo.clients.model.response.ResponseRefund;
import com.payment.demo.controller.Refunds.dto.RefundDtoIn;

public interface RefreshService {
    ResponseRefund createRefund(RefundDtoIn refund);

    ResponseRefund getRefunds(String refundId);
}
