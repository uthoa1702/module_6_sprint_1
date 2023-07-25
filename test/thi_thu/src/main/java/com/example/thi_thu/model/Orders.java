package com.example.thi_thu.model;



import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private Double total;

    @Column(name = "is_delete", columnDefinition = "BIT DEFAULT 0")
    private boolean isDelete;

    @CreationTimestamp
    @Column(name = "create_time" , columnDefinition = "TIMESTAMP DEFAULT now()")
    private LocalDateTime createTime;


    private Integer amount;

    public Orders(Customer customer, Double total, Integer amount) {
        this.customer = customer;
        this.total = total;
        this.amount = amount;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public Orders(Long id, Customer customer, Double total, boolean isDelete, LocalDateTime createTime, Integer amount) {
        this.id = id;
        this.customer = customer;
        this.total = total;
        this.isDelete = isDelete;
        this.createTime = createTime;
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Orders() {
    }

    public Orders(Long id) {
        this.id = id;
    }

    public Orders(Long id, Customer customer, Double total) {
        this.id = id;
        this.customer = customer;
        this.total = total;
    }

    public Orders(Long id, Customer customer, Double total, LocalDateTime createTime) {
        this.id = id;
        this.customer = customer;
        this.total = total;
        this.createTime = createTime;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }


}
