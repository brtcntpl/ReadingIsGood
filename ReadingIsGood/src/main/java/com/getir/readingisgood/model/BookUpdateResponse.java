package com.getir.readingisgood.model;

import com.getir.readingisgood.dto.BookDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookUpdateResponse {

    private ResponseHeader responseHeader;
    private Long bookId;
    private String bookName;
    private Long oldQuantity;
    private Long newQuantty;

}
