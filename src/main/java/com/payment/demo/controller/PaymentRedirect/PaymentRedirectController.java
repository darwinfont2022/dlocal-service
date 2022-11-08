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
        return new ResponseEntity<>(mapper.map(this.service.createPayment(createRedirectPaymentDto), RedirectPaymentCreatedDto.class), HttpStatus.CREATED);
    }

    @PostMapping("/payment-ticket")
    public ResponseEntity<ResponsePayment> createPaymetTycket(@RequestBody CreateRedirectPaymentDto dto) {
        return ResponseEntity.ok(this.service.createPaymentWithTicket(dto));
    }

    @PostMapping("/bankTransfer")
    public ResponseEntity<ResponsePayment> bankTransfer(@RequestBody CreateRedirectPaymentDto paymentDto) {
        return ResponseEntity.ok(service.createBankTranference(paymentDto));
    }
}
