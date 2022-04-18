package com.getir.readingisgood.repository;

import com.getir.readingisgood.entity.Orders;
import com.getir.readingisgood.entity.OrderBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderBookRepository extends JpaRepository<OrderBook, Long> {

    List<OrderBook> findAllByOrders(Orders orders);

}
