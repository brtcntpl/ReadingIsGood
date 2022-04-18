package com.getir.readingisgood.exception;

import org.springframework.http.HttpStatus;

public class CustomerAlreadyRegisteredException extends RuntimeException {

    private final String name = HttpStatus.CONFLICT.getReasonPhrase();
    private final HttpStatus status = HttpStatus.CONFLICT;

    public CustomerAlreadyRegisteredException(String message)  {
        super(message);
    }

    public String getName() {
        return this.name;
    }

    public HttpStatus getStatus() {
        return this.status;
    }
}
