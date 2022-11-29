package com.payment.demo.controller.Refunds;

import com.payment.demo.clients.model.request.RequestRefund;
import com.payment.demo.clients.model.response.ResponseRefund;
import com.payment.demo.controller.Refunds.dto.RefundDtoIn;
import com.payment.demo.service.Refunds.RefundServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/refunds")
@CrossOrigin(origins = "*")
public class RefundsController {

    private final RefundServiceImp service;

    public RefundsController(RefundServiceImp service) {
        this.service = service;
    }

    @PostMapping("")
    public ResponseEntity<ResponseRefund> refunds(@RequestBody RefundDtoIn refund){
        return ResponseEntity.ok(this.service.createRefund(refund));
    }

    @GetMapping()
    public ResponseEntity<ResponseRefund> getRefunds(@RequestParam("id") String id){
        return ResponseEntity.ok(this.service.getRefunds(id));
    }
}
