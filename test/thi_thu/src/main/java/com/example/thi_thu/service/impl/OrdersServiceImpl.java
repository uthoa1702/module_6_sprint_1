package com.example.thi_thu.service.impl;

import com.example.thi_thu.dto.IOrdersDTO;
import com.example.thi_thu.dto.OrdersDTO;
import com.example.thi_thu.model.Customer;
import com.example.thi_thu.model.Orders;
import com.example.thi_thu.repository.ICustomerRepository;
import com.example.thi_thu.repository.IOrderDetailRepository;
import com.example.thi_thu.repository.OrdersRepository;
import com.example.thi_thu.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private ICustomerRepository iCustomerRepository;
    @Autowired
    private IOrderDetailRepository iOrderDetailRepository;

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

    @Override
    public Orders createOrders(Long customerId) {

        Random random = new Random();

        List<Orders> ordersList = ordersRepository.findAll();
        Long[] array = new Long[ordersList.size()];
        for (int i = 0; i < ordersList.size(); i++) {
            array[i] = ordersList.get(i).getId();
        }

        boolean flag = false;
        long a = 0L;
        do {
            a = (long) (Math.random() * (100000 - 1 + 1)) + 1;
            flag = false;

            for (int i = 0; i < array.length; i++) {
                if (Objects.equals(a, array[i])) {
                    flag = true;
                }
            }
        } while (flag == true);

        ordersRepository.createOrdersDb(a, customerId);
        Orders orders = ordersRepository.findById(a).get();
        return orders;

    }

    @Override
    public void createOrderDetail(Long productId, Long price, Long id, Integer amount) {
        iOrderDetailRepository.create(productId, price, id, amount);
    }


    private Page<OrdersDTO> transformDTO(Page<IOrdersDTO> ordersDTOPage) {
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
