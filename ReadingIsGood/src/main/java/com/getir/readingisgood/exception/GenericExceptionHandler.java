package com.getir.readingisgood.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<Object> customerNotFoundExceptionHandler(CustomerNotFoundException ex){
        ex.printStackTrace();
        ErrorWrapper error = new ErrorWrapper(ex.getStatus().getReasonPhrase(), ex.getMessage());
        return buildResponse(error, ex.getStatus());
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<Object> bookNotFoundExceptionHandler(BookNotFoundException ex){
        ex.printStackTrace();
        ErrorWrapper error = new ErrorWrapper(ex.getStatus().getReasonPhrase(), ex.getMessage());
        return buildResponse(error, ex.getStatus());
    }

    @ExceptionHandler(CustomerAlreadyRegisteredException.class)
    public ResponseEntity<Object> customerAlreadyRegisteredException(CustomerAlreadyRegisteredException ex){
        ex.printStackTrace();
        ErrorWrapper error = new ErrorWrapper(ex.getStatus().getReasonPhrase(), ex.getMessage());
        return buildResponse(error, ex.getStatus());
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<Object> orderNotFoundExceptionHandler(OrderNotFoundException ex){
        ex.printStackTrace();
        ErrorWrapper error = new ErrorWrapper(ex.getStatus().getReasonPhrase(), ex.getMessage());
        return buildResponse(error, ex.getStatus());
    }

    @ExceptionHandler(ValidationErrorException.class)
    public ResponseEntity<Object> validationErrorExceptionHandler(ValidationErrorException ex){
        ex.printStackTrace();
        ErrorWrapper error = new ErrorWrapper(ex.getStatus().getReasonPhrase(), ex.getMessage());
        return buildResponse(error, ex.getStatus());
    }

    private ResponseEntity<Object> buildResponse(ErrorWrapper error, HttpStatus httpStatus){
        ResponseWrapper<ErrorWrapper> errorWrapper = new ResponseWrapper<>(error, httpStatus.value());
        return new ResponseEntity<>(errorWrapper, httpStatus);
    }
}
