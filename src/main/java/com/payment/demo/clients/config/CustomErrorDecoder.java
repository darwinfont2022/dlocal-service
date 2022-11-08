package com.payment.demo.clients.config;

import com.payment.demo.exeptions.ExceptionFeignClient;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;

import java.io.IOException;

@Slf4j
public class CustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        String url = response.request().url();
        Response.Body responseBody = response.body();
        var status = response.status();

        log.error("URL: " + url);
        log.error("Estado " + status);
        log.error("Body " + response.reason());

        switch (status) {
            case 400: throw new ExceptionFeignClient("Bad request");
            case 403: throw new ExceptionFeignClient("No esta autirizado a usar esta API");
            case 404: throw new ExceptionFeignClient("Not found");
            case 500: throw new ExceptionFeignClient("Dlocal failed");
        }

        return null;
    }
}
