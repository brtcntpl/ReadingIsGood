package com.getir.readingisgood.service;

import com.getir.readingisgood.dto.BookOrderDTO;
import com.getir.readingisgood.dto.OrderDTO;
import com.getir.readingisgood.entity.Book;
import com.getir.readingisgood.entity.User;
import com.getir.readingisgood.entity.Orders;
import com.getir.readingisgood.entity.OrderBook;
import com.getir.readingisgood.exception.BookNotFoundException;
import com.getir.readingisgood.exception.OrderNotFoundException;
import com.getir.readingisgood.model.*;
import com.getir.readingisgood.repository.BookRepository;
import com.getir.readingisgood.repository.OrderBookRepository;
import com.getir.readingisgood.repository.OrderRepository;
import com.getir.readingisgood.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderService {

    private final BookService bookService;
    private final CustomerService customerService;
    private final BookRepository bookRepository;
    private final OrderRepository orderRepository;
    private final OrderBookRepository orderBookRepository;
    private final MapperUtil mapperUtil;

    @Transactional
    public OrderResponse newOrder(OrderRequest orderRequest) {
        BigDecimal amount = BigDecimal.ZERO;
        Long booksCount =0L;
        Orders orders = Orders.builder().build();
        User customer = customerService.getCustomerById(orderRequest.getCustomerId());
        List<BookOrderDTO> orderDTOS = new ArrayList<>();
        for (BookOrderDTO bookOrder : orderRequest.getBookOrders()) {
            Book book = bookService.getBookIdAndQuantity(bookOrder.getBook().getId(), bookOrder.getCount());
            if (book == null) {
                throw new BookNotFoundException("Book not found or insufficient stock");
            } else {
                amount = amount.add(book.getPrice().multiply(new BigDecimal(bookOrder.getCount())));
                booksCount += bookOrder.getCount();
                OrderBook orderBook = new OrderBook(orders,book,bookOrder.getCount());
                orderBookRepository.save(orderBook);
                BookOrderDTO bookOrderDTO= mapperUtil.convert(orderBook, new BookOrderDTO());
                orderDTOS.add(bookOrderDTO);

            }
            book.setQuantity(book.getQuantity() - bookOrder.getCount());
            bookRepository.save(book);
        }
        orders.setCustomer(customer);
        orders.setBookCount(booksCount);
        orders.setAmount(amount);
        orderRepository.save(orders);
        OrderDTO orderDTO = mapperUtil.convert(orders,new OrderDTO());
        orderDTO.setBookOrders(orderDTOS);
        return new OrderResponse(new ResponseHeader(), orderDTO);
    }

    public OrderDTO getOrderById(Long id) {

        Orders orders = orderRepository.findById(id).
                orElseThrow(() -> new OrderNotFoundException("Order not found."));
        List<OrderBook> orderBooks = orderBookRepository.findAllByOrders(orders);
        OrderDTO responseDTO = mapperUtil.convert(orders,new OrderDTO());
        responseDTO.setBookOrders(new ArrayList<>());
        orderBooks.forEach( orderBook -> {
            responseDTO.getBookOrders().add(mapperUtil.convert(orderBook,new BookOrderDTO()));
        });
        return responseDTO;
    }

    public List<Orders> getOrders() {
        return orderRepository.findAll();
    }


    public GetOrderBetweenDatesResponse getOrderByDate(GetOrderBetweenDatesRequest getOrderBetweenDatesRequest) {
        List<Orders> orders = orderRepository.getAllBetweenDates(getOrderBetweenDatesRequest.getStartDate(),
                getOrderBetweenDatesRequest.getEndDate());
        List<OrderDTO> orderDTOS = new ArrayList<>();
        orders.forEach(order -> {
            List<OrderBook> orderBooks = orderBookRepository.findAllByOrders(order);
            OrderDTO responseDTO = mapperUtil.convert(order,new OrderDTO());
            responseDTO.setBookOrders(new ArrayList<>());
            orderBooks.forEach( orderBook -> {
                responseDTO.getBookOrders().add(mapperUtil.convert(orderBook,new BookOrderDTO()));
            });
            orderDTOS.add(responseDTO);
        });
        return new GetOrderBetweenDatesResponse(new ResponseHeader(),orderDTOS);
    }

}
