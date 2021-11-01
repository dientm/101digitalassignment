package com.digital.assignment.coreservice.exception;

import constant.ErrorCode;
import lombok.Getter;

@Getter
public class BadRequestException extends RuntimeException{

    private final String code;

    public BadRequestException(){
        super();
        this.code = ErrorCode.REQUEST_INVALID.getCode();
    }

    public BadRequestException(String message){
        super(message);
        this.code = ErrorCode.REQUEST_INVALID.getCode();
    }

    public BadRequestException(String message, Throwable e){
        super(message, e);
        this.code = ErrorCode.REQUEST_INVALID.getCode();
    }

    public BadRequestException(String code, String message){
        super(message);
        this.code = code;
    }
}
