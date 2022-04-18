package com.getir.readingisgood.service;

import com.getir.readingisgood.dto.MonthlyStatisticsDTO;
import com.getir.readingisgood.model.*;
import com.getir.readingisgood.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StatisticsService {

    private final OrderRepository orderRepository;

    public MonthlyStatisticsResponse getMonthlyOrderStatistics(MonthlyStatisticsRequest monthlyStatisticsRequest) {
        List<MonthlyStatisticsDTO> monthlyStatisticsDTO = orderRepository.
                getStatisticsMontlyByDate(monthlyStatisticsRequest.getStartDate(),
                        monthlyStatisticsRequest.getEndDate());
        return new MonthlyStatisticsResponse(new ResponseHeader(),monthlyStatisticsDTO);
    }
}
