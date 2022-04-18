package com.getir.readingisgood.model;

import com.getir.readingisgood.dto.BookOrderDTO;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderRequest {

    @NotNull
    private long customerId;
    @NotNull
    private List<BookOrderDTO> bookOrders;
    private BigDecimal amount;
}
