package com.getir.readingisgood.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "ORDER_BOOK")


@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class OrderBook extends BaseEntity {

    @JoinColumn(name = "orders_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Orders orders;

    @JoinColumn(name = "book_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Book book;

    @Column
    private Long count;

}
