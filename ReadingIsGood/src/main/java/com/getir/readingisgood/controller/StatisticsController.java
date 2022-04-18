package com.getir.readingisgood.controller;

import com.getir.readingisgood.model.MonthlyStatisticsRequest;
import com.getir.readingisgood.model.MonthlyStatisticsResponse;
import com.getir.readingisgood.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "api/v1/statistics")
@RequiredArgsConstructor
public class StatisticsController {

    private final StatisticsService statisticsService;
    @GetMapping()
    public MonthlyStatisticsResponse getMonthlyOrderStatistics(@RequestBody @Valid MonthlyStatisticsRequest monthlyStatisticsRequest) {
        return statisticsService.getMonthlyOrderStatistics(monthlyStatisticsRequest);
    }
}
