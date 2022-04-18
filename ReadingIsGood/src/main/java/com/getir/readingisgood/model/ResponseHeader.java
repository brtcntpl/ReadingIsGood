package com.getir.readingisgood.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ResponseHeader implements Serializable {

    private Long resultCode;
    private String resultDesc;

    public ResponseHeader() {
        this.resultDesc = "SUCCESS";
        this.resultCode = 200L;
    }
}
