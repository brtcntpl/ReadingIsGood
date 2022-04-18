package com.getir.readingisgood.dto;


import com.getir.readingisgood.entity.Book;
import com.getir.readingisgood.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookOrderDTO {

    private Orders orders;
    private Book book;
    private Long count;
}
