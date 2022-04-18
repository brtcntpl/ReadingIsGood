package com.getir.readingisgood.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CustomerOrderRequest {
    @NotNull
    private Long customerId;
    private Integer page;
    private Integer size;

}
