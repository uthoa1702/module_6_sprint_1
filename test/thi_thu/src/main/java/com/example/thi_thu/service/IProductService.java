package com.example.thi_thu.service;

import com.example.thi_thu.dto.ProductDTO;
import com.example.thi_thu.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<ProductDTO> getProductList(Pageable pageable);

    void create(ProductDTO productDTO);

    Product findById(Long productId);
}
