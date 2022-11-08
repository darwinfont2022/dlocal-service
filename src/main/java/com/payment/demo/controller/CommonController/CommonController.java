package com.payment.demo.controller.CommonController;

import com.payment.demo.clients.model.response.CurrencyExchange;
import com.payment.demo.clients.model.response.PaymentMethod;
import com.payment.demo.clients.model.response.ResponseOrder;
import com.payment.demo.clients.model.response.ResponsePayment;
import com.payment.demo.controller.CommonController.dto.OrderShipDto;
import com.payment.demo.controller.PaymentRedirect.dto.response.RedirectPaymentCreatedShipDto;
import com.payment.demo.service.CommonService.CommonServiceImp;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("")
@CrossOrigin(origins = "*")
public class CommonController {
    private final CommonServiceImp service;

    private final ModelMapper mapper;

    public CommonController(CommonServiceImp service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/order")
    public ResponseEntity<OrderShipDto> getStatusOrderById(@RequestParam(name = "id") String id){
        return ok(this.service.getOrderById(id));
    }

    @GetMapping("/order-details")
    public ResponseEntity<ResponseOrder> getOrderDetails(@RequestParam(name = "id") String id) {
        return ResponseEntity.ok(this.service.getOrderDetail(id));
    }

    @GetMapping("/payment")
    public ResponseEntity<RedirectPaymentCreatedShipDto> getPayment(@RequestParam(name = "id") String id){
        return ResponseEntity.ok(mapper.map(this.service.getPaymentById(id), RedirectPaymentCreatedShipDto.class));
    }

    @GetMapping("/payment-details")
    public ResponseEntity<ResponsePayment> getPaymentDetailsById(@RequestParam(name = "id") String paymentId) {
        return ResponseEntity.ok(this.service.getPaymentDetails(paymentId));
    }

    @GetMapping(value = "/methods", produces = "application/json")
    public ResponseEntity<List<PaymentMethod>> getMethods(@RequestParam(name = "country", defaultValue = "UY") String country, @RequestParam(name = "type", defaultValue = "") String type){
        return ResponseEntity.ok(service.getMethods(country, type));
    }

    @GetMapping(value = "/currency-exchange", produces = "application/json")
    public ResponseEntity<CurrencyExchange> getCurrencyExchanges(@RequestParam(name = "from", defaultValue = "USD") String from, @RequestParam(name = "to", defaultValue = "UYU") String to){
        return ResponseEntity.ok(service.getCurrencyExchanges(from, to));
    }
}
