package com.getir.readingisgood.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookDTO extends BaseEntityDTO {

    private String name;
    private String writer;
    private Long quantity;
    private BigDecimal price;

}
