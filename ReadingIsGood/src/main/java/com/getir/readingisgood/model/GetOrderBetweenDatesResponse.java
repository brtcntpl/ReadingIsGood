package com.getir.readingisgood.model;

import com.getir.readingisgood.dto.MonthlyStatisticsDTO;
import com.getir.readingisgood.dto.OrderDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetOrderBetweenDatesResponse extends ResponseHeader {
    private ResponseHeader responseHeader;
    private List<OrderDTO> orderDTOS;
}
