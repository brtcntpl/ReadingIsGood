package com.getir.readingisgood.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class MonthlyStatisticsRequest {

    private Date startDate;
    private Date endDate;

}
