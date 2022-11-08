package com.payment.demo.clients.config;

import feign.RequestTemplate;
import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class FeignConfig implements feign.RequestInterceptor {

    @Value("${dlocal.x_login}")
    private String x_login;
    @Value("${dlocal.x_secret_key}")
    private String x_secret_key;
    @Value("${dlocal.x_trans_key}")
    private String x_trans_key;
    @Value("${dlocal.x_version}")
    private String x_version;

    public String generateDataTime(){
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");
        df.setTimeZone(tz);
        return df.format(new Date());
    }

    public String generateSignature(String body){
        try {
            String signature = SignatureCalculator.calculateSignature(
                    x_login,
                    generateDataTime(),
                    x_secret_key,
                    body
            );
            return signature;
        } catch (Exception e) {
            System.out.println("Error generating signature: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("Content-Type", "application/json");
        requestTemplate.header("Accept", "application/json");
        requestTemplate.header("X-Date", generateDataTime());
        requestTemplate.header("X-Login", x_login);
        requestTemplate.header("X-Trans-Key", x_trans_key);
        requestTemplate.header("X-Version", x_version);
        requestTemplate.header("User-Agent", "MerchantTest / 1.0");

        if (requestTemplate.body() == null) {
            requestTemplate.header("Authorization","V2-HMAC-SHA256, Signature:"+ generateSignature(""));
        } else {
            requestTemplate.header("Authorization","V2-HMAC-SHA256, Signature:"+ generateSignature(new String(requestTemplate.body())));
        }
    }

//    @Bean
//    public ErrorDecoder errorDecoder() {
//        return new CustomErrorDecoder();
//    }
}
