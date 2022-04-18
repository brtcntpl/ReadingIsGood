package com.getir.readingisgood;

import com.getir.readingisgood.entity.Book;
import com.getir.readingisgood.entity.User;
import com.getir.readingisgood.repository.BookHistoryRepository;
import com.getir.readingisgood.repository.BookRepository;
import com.getir.readingisgood.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@RunWith(MockitoJUnitRunner.class)
class PlayerRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    private BookHistoryRepository bookHistoryRepositoryMock;

    @Test
    void itShouldSaveABookAndGetById() {
        //Given

    }



    @Test
    void registerCustomer() {

    }

}