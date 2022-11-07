package com.payment.demo.exeptions;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ApiExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            BadRequestException.class,
            FeignException.BadRequest.class,
            MissingPathVariableException.class,
            MissingRequestHeaderException.class,
            MissingServletRequestParameterException.class
    })
    @ResponseBody
    public ResponseEntity<ExceptionMessage> badRequestException(HttpServletRequest request, Exception exception) {
        var err = new ExceptionMessage(exception.getLocalizedMessage(), "Bad request ",request.getRequestURI());
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({
            FeignException.NotFound.class,
            NotFoundExeption.class
    })
    @ResponseBody
    public ResponseEntity<ExceptionMessage> notFoundException(HttpServletRequest request, Exception exception) {
        var err = new ExceptionMessage(exception.getLocalizedMessage(), "Not found ", request.getRequestURI());
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler({
            FeignException.Forbidden.class,
            HttpClientErrorException.Forbidden.class
    })
    @ResponseBody
    public ResponseEntity<ExceptionMessage> forbiddenException(HttpServletRequest request, Exception exception) {
        var err = new ExceptionMessage(exception.getLocalizedMessage(), "Forbiden", request.getRequestURI());
        return new ResponseEntity<>(err, HttpStatus.FORBIDDEN);
    }

    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    @ExceptionHandler({
         FeignException.class,
         Exception.class,
         RuntimeException.class
    })
    @ResponseBody
    public ResponseEntity<ExceptionMessage> errorServer(HttpServletRequest request, Exception exception) {
        var err = new ExceptionMessage(exception.getLocalizedMessage(), "Error", request.getRequestURI());
        return new ResponseEntity<>(err, HttpStatus.EXPECTATION_FAILED);
    }
}
