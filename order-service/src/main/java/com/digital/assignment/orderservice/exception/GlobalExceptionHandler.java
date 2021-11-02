package com.digital.assignment.orderservice.exception;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

import com.fasterxml.jackson.core.JsonParseException;

import constant.ErrorCode;
import msg.BaseResponse;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(value = OrderNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> shopNotFoundException(OrderNotFoundException exception) {
        return new ResponseEntity<>("Order not found", HttpStatus.NOT_FOUND);
    }
}
