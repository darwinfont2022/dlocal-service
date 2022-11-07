package com.payment.demo.service.OrderService;

import com.payment.demo.clients.FeignClientDlocal;
import com.payment.demo.clients.model.response.ResponseOrder;
import com.payment.demo.controller.Order.dto.OrderShipDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImp {
    private final FeignClientDlocal dlocal;
    private final ModelMapper mapper;

    public OrderServiceImp(FeignClientDlocal dlocal, ModelMapper mapper) {
        this.dlocal = dlocal;
        this.mapper = mapper;
    }

    public OrderShipDto getOrderById(String orderId) {
        try {
            var order = dlocal.getOrderById(orderId);
            return mapper.map(order, OrderShipDto.class);
        } catch (Exception e) {
            log.error("Order not found " + orderId + "\n\n" + e);
            return null;
        }
    }

    public ResponseOrder getOrderDetail(String orderId) {
        try {
            return dlocal.getOrderById(orderId);
        } catch (Exception e) {
            log.error("Order not found " + orderId + "\n\n" + e);
            return null;
        }
    }
}
