package com.getir.readingisgood.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ORDERS")
public class Orders extends BaseEntity {

    @JoinColumn(name = "customer_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private User customer;
    private Long bookCount;

    private BigDecimal amount;

}
