package com.getir.readingisgood.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@ToString
@Embeddable
public class ChangeEntry implements Serializable {
    private String fieldName;
    private String oldValue;
    private String newValue;
}