package com.getir.readingisgood.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    private final String name = HttpStatus.NOT_FOUND.getReasonPhrase();
    private final HttpStatus status = HttpStatus.NOT_FOUND;

    public NotFoundException(String message)  {
        super(message);
    }

    public String getName() {
        return this.name;
    }

    public HttpStatus getStatus() {
        return this.status;
    }
}
