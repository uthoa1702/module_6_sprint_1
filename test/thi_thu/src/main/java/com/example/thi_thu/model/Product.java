package com.example.thi_thu.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Long price;

    @CreationTimestamp
    @Column(name = "create_time", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT now()")
    private LocalDateTime createTime;


    @UpdateTimestamp
    @Column(name = "update_time", nullable = false, updatable = true, columnDefinition = "TIMESTAMP DEFAULT now()")
    private LocalDateTime updateTime;

    @Column(nullable = false)
    private LocalDate expiredDate;

    @ManyToOne
    @JoinColumn(name = "product_type_id", nullable = false)
    private ProductType productType;

    @Column(name = "is_delete" , columnDefinition = "BIT DEFAULT 0")
    private boolean isDelete;

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public Product(Long id, String name, Long price, LocalDateTime createTime, LocalDateTime updateTime, LocalDate expiredDate, ProductType productType, boolean isDelete) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.expiredDate = expiredDate;
        this.productType = productType;
        this.isDelete = isDelete;
    }

    public Product() {
    }

    public Product(Long id) {
        this.id = id;
    }

    public Product(Long id, String name, Long price, LocalDate expiredDate, ProductType productType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.expiredDate = expiredDate;
        this.productType = productType;
    }

    public Product(String name, Long price, LocalDate expiredDate, ProductType productType) {
        this.name = name;
        this.price = price;
        this.expiredDate = expiredDate;
        this.productType = productType;
    }

    public Product(Long id, String name, Long price, LocalDateTime createTime, LocalDateTime updateTime, LocalDate expiredDate, ProductType productType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.expiredDate = expiredDate;
        this.productType = productType;
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

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
}
