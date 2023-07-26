package com.example.thi_thu.model;

import javax.persistence.*;

@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @JoinColumn(nullable = false)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;

    private Integer amount;

    public OrderDetail(Long id, Double price, Product product, Orders order, Integer amount) {
        this.id = id;
        this.price = price;
        this.product = product;
        this.order = order;
        this.amount = amount;
    }

    public OrderDetail(Double price, Product product, Orders order, Integer amount) {
        this.price = price;
        this.product = product;
        this.order = order;
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public OrderDetail(Long id) {
        this.id = id;
    }

    public OrderDetail(Double price, Product product) {
        this.price = price;
        this.product = product;
    }

    public OrderDetail(Double price, Product product, Orders order) {
        this.price = price;
        this.product = product;
        this.order = order;
    }

    public OrderDetail() {
    }

    public OrderDetail(Long id, Double price, Product product, Orders order) {
        this.id = id;
        this.price = price;
        this.product = product;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }
}
