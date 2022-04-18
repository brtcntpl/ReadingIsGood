package com.getir.readingisgood.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;

@Data
@EqualsAndHashCode
public class BaseEntityDTO implements Serializable {
    protected String id;
    protected String locale;
}
