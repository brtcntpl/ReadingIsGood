package com.getir.readingisgood.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private long id;
    private long customerId;
    private Date createdDate;
    private Long bookCount;
    private List<BookOrderDTO> bookOrders;
    private BigDecimal amount;

}
