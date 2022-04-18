package com.getir.readingisgood.repository;

import com.getir.readingisgood.entity.BookHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

public interface BookHistoryRepository extends JpaRepository<BookHistory, Long>, JpaSpecificationExecutor<BookHistory> {

}
