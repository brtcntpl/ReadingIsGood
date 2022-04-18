package com.getir.readingisgood.controller;

import com.getir.readingisgood.dto.UserDTO;
import com.getir.readingisgood.model.CustomerOrderRequest;
import com.getir.readingisgood.model.CustomerOrderResponse;
import com.getir.readingisgood.service.CustomerService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "/getCustomerOrders")
    @PreAuthorize("hasRole('USER')")
    public CustomerOrderResponse getCustomerOrders(@RequestBody @Valid CustomerOrderRequest customerOrderRequest) {
        return customerService.getCustomerOrders(customerOrderRequest);
    }
}
