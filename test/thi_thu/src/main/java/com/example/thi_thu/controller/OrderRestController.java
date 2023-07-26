package com.example.thi_thu.controller;

import com.example.thi_thu.dto.OrdersDTO;
import com.example.thi_thu.model.Customer;
import com.example.thi_thu.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/admin")
public class OrderRestController {
    @Autowired
    private IOrdersService iOrdersService;

    @GetMapping("/")
    public ResponseEntity<Page<OrdersDTO>> getList(@RequestParam(value = "page", defaultValue = "0") Integer page){
        Pageable pageable = PageRequest.of(page,5);
        Page<OrdersDTO> ordersDTOPage = iOrdersService.getList(pageable);
        if (ordersDTOPage == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ordersDTOPage, HttpStatus.OK);
    }


    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> getCustomerList () {
        List<Customer> customers = iOrdersService.getListCustomer();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
//    @GetMapping("/")
//    public ResponseEntity<Page<OrdersDTO>> getProlductList(@RequestParam(value = "page", defaultValue = "0") Integer page){
//        Pageable pageable = PageRequest.of(page,5);
//        Page<OrdersDTO> ordersDTOPage = iOrdersService.getList(pageable);
//        if (ordersDTOPage == null){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(ordersDTOPage, HttpStatus.OK);
//    }
}
