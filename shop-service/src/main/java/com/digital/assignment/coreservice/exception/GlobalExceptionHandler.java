package com.digital.assignment.coreservice.exception;

import com.fasterxml.jackson.core.JsonParseException;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

import constant.ErrorCode;
import msg.BaseResponse;

//@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {BadRequestException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResponse<Object> badRequestExceptionHandler(BadRequestException e){
        BaseResponse<Object> baseResponse = new BaseResponse<>();
        baseResponse.setCode(e.getCode());
        baseResponse.setMessage(e.getMessage());

        return baseResponse;
    }

    @ExceptionHandler(value = JsonParseException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResponse<Object> businessLogicExceptionHandler(JsonParseException e){
        BaseResponse<Object> baseResponse = new BaseResponse<>();
        baseResponse.setCode(ErrorCode.REQUEST_INVALID.getCode());
        baseResponse.setMessage(e.getMessage());

        return baseResponse;
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResponse<Object> invalidExceptionHandler(MethodArgumentNotValidException e){
        BaseResponse<Object> baseResponse = new BaseResponse<>();
        baseResponse.setCode(ErrorCode.REQUEST_INVALID.getCode());

        List<ObjectError> objectErrorList = e.getBindingResult().getAllErrors();

        if (objectErrorList.isEmpty()){
            baseResponse.setMessage(ErrorCode.REQUEST_INVALID.getMessage());
        }else{
            String defaultMessage = objectErrorList.get(0).getDefaultMessage();

            baseResponse.setMessage(StringUtils.isBlank(defaultMessage) ? ErrorCode.REQUEST_INVALID.getMessage() : defaultMessage);
        }
        return baseResponse;
    }

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResponse<Object> invalidHttpMessage(HttpMessageNotReadableException e){
        BaseResponse<Object> baseResponse = new BaseResponse<>();
        baseResponse.setCode(ErrorCode.REQUEST_INVALID.getCode());
        baseResponse.setMessage(e.getMessage());

        return baseResponse;
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseResponse<Object> generalExceptionHandler(Exception e){
        BaseResponse<Object> baseResponse = new BaseResponse<>();
        baseResponse.setCode(ErrorCode.GENERAL_ERROR.getCode());
        baseResponse.setMessage(e.getMessage());

        return baseResponse;
    }

    @ExceptionHandler(value = HttpClientErrorException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResponse<Object> generalExceptionHandler(HttpClientErrorException e){
        BaseResponse<Object> baseResponse = new BaseResponse<>();
        baseResponse.setCode(ErrorCode.REQUEST_INVALID.getCode());
        baseResponse.setMessage(e.getMessage());

        return baseResponse;
    }
}
