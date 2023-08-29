package com.example.thi_thu.service;

import com.example.thi_thu.dto.OrdersDTO;
import com.example.thi_thu.model.Customer;
import com.example.thi_thu.model.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IOrdersService {
    Page<OrdersDTO> getList(Pageable pageable);

    List<Customer> getListCustomer();

    Orders createOrders(Long customerId);

    void createOrderDetail(Long productId, Long price, Long id, Integer amount);
}
