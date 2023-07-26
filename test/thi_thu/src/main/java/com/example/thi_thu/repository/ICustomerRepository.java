package com.example.thi_thu.repository;

import com.example.thi_thu.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "SELECT *\n" +
            "FROM customer", nativeQuery = true)
    List<Customer> findAllCus();

}
