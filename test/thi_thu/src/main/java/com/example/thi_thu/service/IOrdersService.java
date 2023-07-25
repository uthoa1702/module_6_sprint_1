package com.example.thi_thu.service;

import com.example.thi_thu.dto.OrdersDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IOrdersService {
    Page<OrdersDTO> getList(Pageable pageable);
}
