package com.payment.demo.service.CommonService;

import com.payment.demo.clients.FeignClientDlocal;
import com.payment.demo.clients.model.response.CurrencyExchange;
import com.payment.demo.clients.model.response.PaymentMethod;
import com.payment.demo.clients.model.response.ResponseOrder;
import com.payment.demo.clients.model.response.ResponsePayment;
import com.payment.demo.controller.CommonController.dto.OrderShipDto;
import com.payment.demo.exeptions.NotFoundExeption;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommonServiceImp implements CommonService {
    private final FeignClientDlocal dlocal;
    private final ModelMapper mapper;

    public CommonServiceImp(FeignClientDlocal dlocal, ModelMapper mapper) {
        this.dlocal = dlocal;
        this.mapper = mapper;
    }
    @Override
    public OrderShipDto getOrderById(String orderId) {
        try {
            var order = dlocal.getOrderById(orderId);
            return mapper.map(order, OrderShipDto.class);
        } catch (Exception e) {
            log.error("CommonController not found " + orderId + "\n\n" + e);
            return null;
        }
    }
    @Override
    public ResponseOrder getOrderDetail(String orderId) {
        try {
            return dlocal.getOrderById(orderId);
        } catch (Exception e) {
            log.error("CommonController not found " + orderId + "\n\n" + e);
            return null;
        }
    }

    @Override
    public ResponsePayment getPaymentById(String id) {
        try {
            return this.dlocal.getPaymentById(id);
        } catch (Exception e) {
            log.error("Exception getting payment " + id + "\n\n" + e.getMessage());
            throw new NotFoundExeption("payment" + id);
        }
    }

    @Override
    public ResponsePayment getPaymentDetails(String paymentId) {
        try {
            return this.dlocal.getPaymentById(paymentId);
        } catch (Exception e) {
            log.error("Exception getting payment " + paymentId + "\n\n" + e.getMessage());
            throw new NotFoundExeption("payment " + paymentId);
        }
    }

    public List<PaymentMethod> getMethods(String country, String type) {
        try {
            var methods = dlocal.getPaymentsMethods(country);
            //Filtrado de metodos por tipo CARD
            if(!type.isBlank()) {
                methods = methods.stream().filter(method -> method.getType().equals(type)).collect(Collectors.toList());
            }
            return methods;
        } catch (Exception e) {
            log.error("Error getting payments methods");
            throw new NotFoundExeption(" Error getting payments methods for this: " + country);
        }
    }

    public CurrencyExchange getCurrencyExchanges(String from, String to) {
        try {
            return dlocal.currencyExchanges(from, to);
        } catch (Exception e){
            throw new NotFoundExeption(" Error getting currency exchange: " + from + " to " + to);
        }
    }
}
