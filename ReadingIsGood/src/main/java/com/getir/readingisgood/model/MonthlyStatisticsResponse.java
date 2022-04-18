package com.getir.readingisgood.model;

import com.getir.readingisgood.dto.MonthlyStatisticsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonthlyStatisticsResponse extends ResponseHeader {
    private ResponseHeader responseHeader;
    private List<MonthlyStatisticsDTO> monthlyStatisticsDTOList;

}
