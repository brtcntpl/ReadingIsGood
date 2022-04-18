package com.getir.readingisgood.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class MonthlyStatisticsDTO {

    private String month;
    private Long totalOrderCount;
    private Long totalBookCount;
    private BigDecimal totalPurchasedAmount;

    public MonthlyStatisticsDTO(String month, Long totalOrderCount, Long totalBookCount, BigDecimal totalPurchasedAmount) {
        this.month = month;
        this.totalOrderCount = totalOrderCount;
        this.totalBookCount = totalBookCount;
        this.totalPurchasedAmount = totalPurchasedAmount;
    }
}
