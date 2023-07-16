package com.example.demo.repository;

import com.example.back_end.model.Contracts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IRedeemingRepository extends JpaRepository<Contracts, Long> {
    @Modifying
    @Query(value = "UPDATE contracts SET contract_status_id = 2 WHERE id = :id",nativeQuery = true)
    void redeem(@Param("id") Long id);
}
