package com.getir.readingisgood.model;

import com.getir.readingisgood.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerOrderResponse  extends ResponseHeader{
    private ResponseHeader responseHeader;
    private Long customerId;
    private List<Orders> orderPage;
}
