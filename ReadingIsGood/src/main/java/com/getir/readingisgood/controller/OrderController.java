package com.getir.readingisgood.controller;

import com.getir.readingisgood.dto.OrderDTO;
import com.getir.readingisgood.model.*;
import com.getir.readingisgood.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("getOrderByDate")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public GetOrderBetweenDatesResponse getOrderByDate(@RequestBody @Valid GetOrderBetweenDatesRequest getOrderBetweenDatesRequest) {
        return orderService.getOrderByDate(getOrderBetweenDatesRequest);
    }

    @GetMapping("/getOrderById/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public OrderDTO getOrderById(@PathVariable Long id) {

        return orderService.getOrderById(id);
    }


    @PostMapping("/newOrder")
    public OrderResponse newOrder(@RequestBody @Valid OrderRequest orderRequest) {
        return orderService.newOrder(orderRequest);
    }

}
