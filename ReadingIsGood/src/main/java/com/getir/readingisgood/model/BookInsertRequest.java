package com.getir.readingisgood.model;

import com.getir.readingisgood.dto.BookDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookInsertRequest  {

    private String name;
    private String writer;
    private Long quantity;
    private BigDecimal price;

}
