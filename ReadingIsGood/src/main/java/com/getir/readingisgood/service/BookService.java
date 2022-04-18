package com.getir.readingisgood.service;

import com.getir.readingisgood.dto.BookDTO;
import com.getir.readingisgood.entity.BookHistory;
import com.getir.readingisgood.entity.OrderBook;
import com.getir.readingisgood.model.*;
import com.getir.readingisgood.entity.Book;
import com.getir.readingisgood.exception.BookNotFoundException;
import com.getir.readingisgood.repository.BookHistoryRepository;
import com.getir.readingisgood.repository.BookRepository;
import com.getir.readingisgood.repository.OrderBookRepository;
import com.getir.readingisgood.util.MapperUtil;
import com.sun.istack.logging.Logger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Level;

@Component
@RequiredArgsConstructor
public class BookService {

    private static final Logger LOGGER = Logger.getLogger(BookService.class);
    private final BookRepository bookRepository;
    private final MapperUtil mapperUtil;
    private final OrderBookRepository orderBookRepository;
    private final BookHistoryRepository bookHistoryRepository;
    public BookUpdateResponse bookUpdate(BookUpdateRequest bookUpdateRequest) {
        Book book = bookRepository.findById(bookUpdateRequest.getBookId()).
                orElseThrow(() -> new BookNotFoundException("Book not found."));
        book.setQuantity(book.getQuantity() + bookUpdateRequest.getQuantity());
        bookRepository.save(book);
        return new BookUpdateResponse(new ResponseHeader(),book.getId(),book.getName(),
                book.getQuantity()-bookUpdateRequest.getQuantity(),book.getQuantity());
    }

    public BookInsertResponse bookInsert(BookInsertRequest bookInsertRequest) {

        Book book = Book.builder().name(bookInsertRequest.getName()).price(bookInsertRequest.getPrice())
                .quantity(bookInsertRequest.getQuantity()).writer(bookInsertRequest.getWriter()).build();
        return new BookInsertResponse(new ResponseHeader(), mapperUtil.convert(bookRepository.save(book), new BookDTO()));

    }

    public List<OrderBook> getBookOrders(){
        return orderBookRepository.findAll();
    }

    public List<BookHistory> getBookHistory(){
        return bookHistoryRepository.findAll();
    }

    public Book getBookIdAndQuantity(Long bookId, Long quantity) {
        return bookRepository.findBookByIdAndQuantityGreaterThanEqual(bookId,quantity);
    }
}
