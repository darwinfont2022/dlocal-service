package com.payment.demo.controller.PaymentRedirect;

import com.payment.demo.clients.model.response.ResponsePayment;
import com.payment.demo.controller.PaymentRedirect.dto.request.CreateRedirectPaymentDto;
import com.payment.demo.controller.PaymentRedirect.dto.response.RedirectPaymentCreatedDto;
import com.payment.demo.controller.PaymentRedirect.dto.response.RedirectPaymentCreatedShipDto;
import com.payment.demo.service.RedirectPaymentService.RedirectServiceImp;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/redirect-payment")
@CrossOrigin(origins = "*")
public class PaymentRedirectController {
    private final RedirectServiceImp service;
    private final ModelMapper mapper;

    public PaymentRedirectController(RedirectServiceImp service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping("")
    public ResponseEntity<RedirectPaymentCreatedDto> createPayment(@RequestBody CreateRedirectPaymentDto createRedirectPaymentDto){
        try {
            return new ResponseEntity<>(mapper.map(service.createPayment(createRedirectPaymentDto), RedirectPaymentCreatedDto.class), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<RedirectPaymentCreatedShipDto> getPayment(@PathVariable(name = "paymentId") String paymentId){
        return ok(mapper.map(service.getPaymentById(paymentId), RedirectPaymentCreatedShipDto.class));
    }

    @GetMapping("/{paymentId}/details")
    public ResponseEntity<ResponsePayment> getPaymentDetailsById(@PathVariable String paymentId) {
        return ResponseEntity.ok(service.getPaymentDetails(paymentId));
    }
}
