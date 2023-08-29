package com.example.thi_thu.controller;

import com.example.thi_thu.dto.OrdersDTO;
import com.example.thi_thu.model.Customer;
import com.example.thi_thu.model.OrderDetail;
import com.example.thi_thu.model.Orders;
import com.example.thi_thu.model.Product;
import com.example.thi_thu.service.IOrdersService;
import com.example.thi_thu.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/admin")
public class OrderRestController {
    @Autowired
    private IOrdersService iOrdersService;
    @Autowired
    private IProductService iProductService;

    @GetMapping("/")
    public ResponseEntity<Page<OrdersDTO>> getList(@RequestParam(value = "page", defaultValue = "0") Integer page) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<OrdersDTO> ordersDTOPage = iOrdersService.getList(pageable);
        if (ordersDTOPage == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ordersDTOPage, HttpStatus.OK);
    }


    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> getCustomerList() {
        List<Customer> customers = iOrdersService.getListCustomer();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }


    @Transactional
    @PostMapping("/create-order")
    public ResponseEntity<String> createOrder(@RequestParam("customerId") Long customerId, @RequestParam("productId") Long productId, @RequestParam("quantity") Integer amount) {
        if (customerId == null && productId == null && amount == null){
            return new ResponseEntity<>("Tao don hang that bai", HttpStatus.BAD_REQUEST);
        }
        Orders orders = iOrdersService.createOrders(customerId);
        Product product = iProductService.findById(productId);
       iOrdersService.createOrderDetail(productId,product.getPrice(),orders.getId(), amount);
        return new ResponseEntity<>("ok", HttpStatus.OK);
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
