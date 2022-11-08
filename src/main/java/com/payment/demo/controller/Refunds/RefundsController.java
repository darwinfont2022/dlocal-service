package com.payment.demo.controller.Refunds;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/refunds")
@CrossOrigin(origins = "*")
public class RefundsController {
    @PostMapping("")
    public void refunds(@RequestBody Object refund){
        System.out.println("Refund from dlocal");
    }
}
