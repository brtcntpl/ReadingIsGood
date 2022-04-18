package com.getir.readingisgood.controller;

import com.getir.readingisgood.entity.BookHistory;
import com.getir.readingisgood.entity.OrderBook;
import com.getir.readingisgood.model.BookInsertRequest;
import com.getir.readingisgood.model.BookInsertResponse;
import com.getir.readingisgood.model.BookUpdateRequest;
import com.getir.readingisgood.model.BookUpdateResponse;
import com.getir.readingisgood.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/v1/book")
@Slf4j
@Api(tags = {"Book Controller "})
@SwaggerDefinition(tags = {
        @Tag(name = "" +
                "Book", description = "Book Controller")
})
public class BookController {

    private final BookService bookService;

    @PostMapping()
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public BookInsertResponse addBook(@RequestBody BookInsertRequest bookInsertRequest) {
        return bookService.bookInsert(bookInsertRequest);
    }

    @PutMapping()
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public BookUpdateResponse bookUpdate(@RequestBody BookUpdateRequest bookUpdateRequest) {
        return bookService.bookUpdate(bookUpdateRequest);
    }

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<OrderBook> getBookOrders() {
        return bookService.getBookOrders();
    }

    @GetMapping("/getBookHistory")
    public List<BookHistory> getBookHistory() {
        return bookService.getBookHistory();
    }
}
