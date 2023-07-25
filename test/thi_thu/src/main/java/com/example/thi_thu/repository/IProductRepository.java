package com.example.thi_thu.repository;

import com.example.thi_thu.dto.IProductDTO;
import com.example.thi_thu.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {


    @Query(value = "SELECT p.id          AS id,\n" +
            "       p.name        AS name,\n" +
            "       p.price       AS price,\n" +
            "       PT.id         AS productType,\n" +
            "       p.create_time AS createTime,\n" +
            "       p.update_time AS updateTime,\n" +
            "       p.expired_date AS expiredDate\n" +
            "FROM product AS p\n" +
            "         INNER JOIN product_type PT ON p.product_type_id = PT.id WHERE is_delete = 0", nativeQuery = true)
    Page<IProductDTO> getList(Pageable pageable);

    @Modifying
    @Query(value = "INSERT INTO product (expired_date, `name`, price,  product_type_id)\n" +
            "VALUES (:expiredDate, :names,:prices , :productType)", nativeQuery = true)
    void create(@Param("names") String names, @Param("prices") Long prices, @Param("expiredDate") LocalDate expiredDate, @Param("productType") Long productType);
}
