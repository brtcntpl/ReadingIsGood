package com.getir.readingisgood.model;
import com.getir.readingisgood.dto.OrderDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private ResponseHeader responseHeader;
    private OrderDTO orderDTO;
}
