package com.payment.demo.service.NotificationService;

import com.google.gson.Gson;
import com.payment.demo.clients.config.SignatureCalculator;
import com.payment.demo.dtos.NotificationDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Service
public class NotificationServiceImp {
    @Value("${dlocal.x_login}")
    private String x_login;
    @Value("${dlocal.x_secret_key}")
    private String x_secret_key;
    private boolean verifySignature (String auth_header, String date_header, String body) throws IOException, NoSuchAlgorithmException, InvalidKeyException {
        String signature = SignatureCalculator.calculateSignature(x_login, date_header, x_secret_key,body);
        if(auth_header.equals("V2-HMAC-SHA256, Signature: ".concat(signature))) {
            return true;
        }else {
            return false;
        }
    }
    public void notification(String auth,String date,String body) {
        try {
            if(verifySignature(auth,date,body)) {
                var notification = new Gson().fromJson(body, NotificationDto.class);
                if (notification.getStatus().equals("PAID")) {
                    System.out.println("\nUpdate order: " + notification.getOrder_id() + " staus: " + notification.getStatus());
                } else {
                    System.out.println("\nNotificar al usuario: no se pudo realizar el pago");
                }
            } else {
                System.out.println("\nIlegal signature");
            }
        } catch (Exception e) {System.out.println("Error: " + e.getMessage());}
    }
}
