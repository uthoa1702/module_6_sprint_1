package com.example.thi_thu.service.impl;

import com.example.thi_thu.dto.IProductDTO;
import com.example.thi_thu.dto.ProductDTO;
import com.example.thi_thu.model.Product;
import com.example.thi_thu.repository.IProductRepository;
import com.example.thi_thu.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired private IProductRepository iProductRepository;
    @Override
    public Page<ProductDTO> getProductList(Pageable pageable) {
       Page<IProductDTO> iProductDTOS =  iProductRepository.getList(pageable);
       return transformDTO(iProductDTOS);
    }

    @Override
    public void create(ProductDTO productDTO) {
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        iProductRepository.create(product.getName(), productDTO.getPrice(), productDTO.getExpiredDate(), productDTO.getProductType()) ;
    }

    private Page<ProductDTO> transformDTO(Page<IProductDTO> productDTOPage){
        return productDTOPage.map(projection -> {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(projection.getId());
            productDTO.setName(projection.getName());
            productDTO.setPrice(projection.getPrice());
            productDTO.setProductType(projection.getProductType());
            productDTO.setExpiredDate(projection.getExpiredDate());
            productDTO.setCreateTime(projection.getCreateTime());
            productDTO.setUpdateTime(projection.getUpdateTime());
           return productDTO;
        });
    }
}
