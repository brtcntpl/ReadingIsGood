package com.getir.readingisgood.repository;

import com.getir.readingisgood.dto.MonthlyStatisticsDTO;
import com.getir.readingisgood.entity.User;
import com.getir.readingisgood.entity.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

    List<Orders> findAllByCustomer(User customer);

    @Query(value = "from Orders t where t.createdDate BETWEEN :startDate AND :endDate")
    List<Orders> getAllBetweenDates(@Param("startDate")Date startDate, @Param("endDate")Date endDate);


    @Query("SELECT NEW com.getir.readingisgood.dto.MonthlyStatisticsDTO(COALESCE(monthname(ubd.createdDate),'Not Announced'), count(ubd.id), sum(ubd.bookCount), sum(ubd.amount)) " +
            " from Orders ubd  where  ubd.createdDate between :startDate and :endDate " +
            " group by COALESCE(monthname(ubd.createdDate),'Not Announced')")
    List<MonthlyStatisticsDTO> getStatisticsMontlyByDate(@Param("startDate")Date startDate, @Param("endDate")Date endDate);


}
