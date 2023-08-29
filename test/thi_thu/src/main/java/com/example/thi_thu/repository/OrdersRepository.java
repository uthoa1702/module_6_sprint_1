package com.example.thi_thu.repository;

import com.example.thi_thu.dto.IOrdersDTO;
import com.example.thi_thu.model.Customer;
import com.example.thi_thu.model.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {


    @Query(value = "SELECT COUNT(order_id) AS amount,\n" +
            "       SUM(P.price)    AS total,\n" +
            "       c.name          AS customerName,\n" +
            "       O.id            AS id\n" +
            "FROM order_detail AS od\n" +
            "         INNER JOIN orders O ON od.order_id = O.id\n" +
            "         INNER JOIN customer C ON O.customer_id = C.id\n" +
            "         INNER JOIN product P ON od.product_id = P.id\n" +
            "GROUP BY od.order_id",nativeQuery = true)
    Page<IOrdersDTO> getPageOrder(Pageable pageable);


    @Query(value = "INSERT INTO orders (id,customer_id) VALUE (:id,:customerId)",nativeQuery = true)
    void createOrdersDb(@Param("id")Long id,@Param("customerId") Long customerId);
}
