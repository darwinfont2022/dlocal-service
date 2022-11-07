package com.payment.demo.controller.Refunds;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
@CrossOrigin(origins = "*")
public class RefundsController {
    @PostMapping("/refunds")
    public void refunds(@RequestBody Object refund){
        System.out.println("Refund from dlocal");
    }
}
