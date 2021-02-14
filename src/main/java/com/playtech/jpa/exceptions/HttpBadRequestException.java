package com.playtech.jpa.exceptions;

public class HttpBadRequestException extends RuntimeException{

    public HttpBadRequestException(String message) {
        super(message);
    }

}
