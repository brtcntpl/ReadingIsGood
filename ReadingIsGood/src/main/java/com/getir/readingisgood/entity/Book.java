package com.getir.readingisgood.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.getir.readingisgood.anotations.Historical;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import java.math.BigDecimal;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BOOK")
@Historical(serviceName = "bookHistoryEntityService")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Book extends BaseEntity {

    private String name;
    private String writer;
    private Long quantity;
    private BigDecimal price;

    @Version
    private int version;
}
