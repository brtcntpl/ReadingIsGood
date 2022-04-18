package com.getir.readingisgood.repository;

import com.getir.readingisgood.entity.Book;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findBookByIdAndQuantityGreaterThanEqual(Long id, Long quantity);
}
