package com.example.thi_thu.service;

import com.example.thi_thu.dto.OrdersDTO;
import com.example.thi_thu.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IOrdersService {
    Page<OrdersDTO> getList(Pageable pageable);

    List<Customer> getListCustomer();
}
