package com.payment.demo.controller.Notification;

import com.payment.demo.service.NotificationService.NotificationServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
@CrossOrigin(origins = "*")
public class Notification {
    @Autowired
    NotificationServiceImp service;
    @PostMapping()
    public void notificaciones(
            @RequestHeader ("authorization") String authorization,
            @RequestHeader("x-date") String date,
            @RequestBody String body){
//        headers.forEach((key, value) -> {
//          System.out.printf("Header '%s' = %s%n", key, value);
//        });
        service.notification(authorization,date, body);
    }
}
