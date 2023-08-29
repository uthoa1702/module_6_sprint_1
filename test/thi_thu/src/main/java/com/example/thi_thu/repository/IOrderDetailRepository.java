package com.example.thi_thu.repository;

import com.example.thi_thu.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderDetailRepository extends JpaRepository<OrderDetail, Long> {


    @Modifying
    @Query(value = "INSERT INTO order_detail (price, order_id, product_id, amount) VALUE (:price,:id, :productId,:amount)",nativeQuery = true)
    void create(@Param("productId") Long productId, @Param("price") Long price, @Param("id") Long id, @Param("amount") Integer amount);
}
