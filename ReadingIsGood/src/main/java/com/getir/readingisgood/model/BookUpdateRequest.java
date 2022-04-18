package com.getir.readingisgood.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookUpdateRequest {

    private Long bookId;
    private Long quantity;

}
