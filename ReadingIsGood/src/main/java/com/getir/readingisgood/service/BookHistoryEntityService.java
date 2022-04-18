package com.getir.readingisgood.service;


import com.getir.readingisgood.entity.BookHistory;
import com.getir.readingisgood.repository.BookHistoryRepository;
import com.getir.readingisgood.service.base.AbstractEntityService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
public class BookHistoryEntityService extends AbstractEntityService<BookHistory,Long> {

    private BookHistoryRepository bookHistoryRepository;

    public BookHistoryEntityService(BookHistoryRepository bookHistoryRepository) {
        this.bookHistoryRepository = bookHistoryRepository;
    }

    @Override
    public JpaRepository<BookHistory, Long> getJpaRepository() {
        return bookHistoryRepository;
    }
}
