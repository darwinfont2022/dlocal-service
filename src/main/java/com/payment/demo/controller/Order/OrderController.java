package com.payment.demo.controller.Order;

import com.payment.demo.clients.model.response.ResponseOrder;
import com.payment.demo.controller.Order.dto.OrderShipDto;
import com.payment.demo.service.OrderService.OrderServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*")
public class OrderController {
    private final OrderServiceImp service;

    public OrderController(OrderServiceImp service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderShipDto> getStatusOrderById(@PathVariable String id){
        return ok(service.getOrderById(id));
    }

    @GetMapping("/{id}/details")
    public ResponseEntity<ResponseOrder> getOrderDetails(@PathVariable String id) {
        return ResponseEntity.ok(service.getOrderDetail(id));
    }
}
