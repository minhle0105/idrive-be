package com.hanoi.heat.idrive.repository;

import com.hanoi.heat.idrive.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {
    @Query(value = "select * from order_detail where start_time like ?1",nativeQuery = true)
    Iterable<OrderDetail> findByDate(String date);
    @Query(value = "select * from order_detail where own_user_id = ?1",nativeQuery = true)
    List<OrderDetail> History(Long id);
    @Query(value = "select * from order_detail group by id having ?1 between min(start_time) and max(end_time)", nativeQuery = true)
    Iterable<OrderDetail> findBetween(Date date);
}
