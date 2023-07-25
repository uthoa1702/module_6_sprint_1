package com.example.thi_thu.controller;

import com.example.thi_thu.dto.ProductDTO;
import com.example.thi_thu.model.Product;
import com.example.thi_thu.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/product")
@CrossOrigin("*")
public class ProductRestController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("/list")
    @Transactional
    public ResponseEntity<Page<ProductDTO>> getProductList(@RequestParam(value = "page", defaultValue = "0") Integer page) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<ProductDTO> productDTOPage = iProductService.getProductList(pageable);
        if (productDTOPage == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productDTOPage, HttpStatus.OK);
    }

    @PostMapping("/create-product")
    @Transactional
    public ResponseEntity<Map<String, String>> createProduct(@Validated @RequestBody ProductDTO productDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> list = new HashMap<>();
            String[] fieldCheck = {"name", "price", "productType","expiredDate"};
            for (String field : fieldCheck) {
                FieldError fieldError = bindingResult.getFieldError(field);
                if (fieldError != null) {
                    list.put(field, fieldError.getDefaultMessage());
                }
            }
            return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
        }
        Map<String, String> statusCreate = new HashMap<>();
        statusCreate.put("status", "success");
        iProductService.create(productDTO);
        return new  ResponseEntity<>(statusCreate, HttpStatus.OK);



    }
}
