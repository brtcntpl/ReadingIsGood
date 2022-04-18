package com.getir.readingisgood.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidationErrorException extends RuntimeException {

    private final String name = HttpStatus.BAD_REQUEST.getReasonPhrase();
    private final HttpStatus status = HttpStatus.BAD_REQUEST;

    public ValidationErrorException(String message)  {
        super(message);
    }

    public String getName() {
        return this.name;
    }

    public HttpStatus getStatus() {
        return this.status;
    }
}
