package com.payment.demo.config;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(FeignException.class)
    public ResponseEntity<ErrorFormatDlocal> handlerDlocalError(FeignException exception) {
        ErrorFormatDlocal error = ErrorFormatDlocal.getDlocalError(exception.getMessage());
        switch (exception.status()) {
            case 403: {
                return  ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
            }
            case 404: {
                return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            }
            case 400: {
                return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
            }
            default: return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(error);
        }
    }

//    public ResponseEntity<?> handlerNootFound(){
//        return null;
//    }
}
