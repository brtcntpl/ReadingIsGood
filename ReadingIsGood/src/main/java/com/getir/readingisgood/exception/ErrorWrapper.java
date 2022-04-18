package com.getir.readingisgood.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.FieldError;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorWrapper {

    private String name;
    private String message;

    private LocalDateTime timestamp = LocalDateTime.now();

    public ErrorWrapper(String name, String message) {
        this.name = name;
        this.message = message;
    }
}