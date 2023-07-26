package com.example.thi_thu.service.impl;

import com.example.thi_thu.dto.IOrdersDTO;
import com.example.thi_thu.dto.OrdersDTO;
import com.example.thi_thu.model.Customer;
import com.example.thi_thu.repository.ICustomerRepository;
import com.example.thi_thu.repository.OrdersRepository;
import com.example.thi_thu.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Page<OrdersDTO> getList(Pageable pageable) {
       Page<IOrdersDTO> ordersDTOPage = ordersRepository.getPageOrder(pageable);
       return transformDTO(ordersDTOPage);

    }

    @Override
    public List<Customer> getListCustomer() {
        List<Customer> customers = iCustomerRepository.findAllCus();
        return customers;
    }

    private Page<OrdersDTO> transformDTO (Page<IOrdersDTO>ordersDTOPage){
        return ordersDTOPage.map(projection -> {
            OrdersDTO ordersDTO = new OrdersDTO();
            ordersDTO.setId(projection.getId());
            ordersDTO.setCustomerName(projection.getCustomerName());
            ordersDTO.setAmount(projection.getAmount());
            ordersDTO.setTotal(projection.getTotal());
            return ordersDTO;
        });
    }
}
