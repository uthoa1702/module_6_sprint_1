package com.example.thi_thu.dto;

import com.example.thi_thu.ValidateExpiredDate;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ProductDTO implements Validator {
    private Long id;

    @NotBlank(message = "need to be filled")
    private String name;


    private Long price;


    private LocalDateTime createTime;


    private LocalDateTime updateTime;

    @ValidateExpiredDate(message = "khong duoc it hon ngay hien tai")
    private LocalDate expiredDate;


    private Long productType;


    public ProductDTO(Long id) {
        this.id = id;
    }

    public ProductDTO(Long id, String name, Long price, LocalDateTime createTime, LocalDateTime updateTime, LocalDate expiredDate, Long productType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.expiredDate = expiredDate;
        this.productType = productType;
    }

    public Long getProductType() {
        return productType;
    }

    public void setProductType(Long productType) {
        this.productType = productType;
    }

    public ProductDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public LocalDate getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(LocalDate expiredDate) {
        this.expiredDate = expiredDate;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
