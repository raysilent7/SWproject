package com.swproject.swproject.services.exception;

public class BadRequestException extends RuntimeException{

    public BadRequestException(String msg) {
        super(msg);
    }
}
