package com.example.demo.model;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
public class Liquidations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn
    private Customers customers;
    @ManyToOne
    @JoinColumn
    private Contracts contracts;
    private Long totalPrice;
    @Column(name = "create_time", columnDefinition = "DATETIME DEFAULT now()",updatable = false)
    @CreationTimestamp
    private LocalDateTime createTime;

    public Liquidations() {
    }

    public Liquidations(Long id, Customers customers, Contracts contracts, Long totalPrice, LocalDateTime createTime) {
        this.id = id;
        this.customers = customers;
        this.contracts = contracts;
        this.totalPrice = totalPrice;
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public Contracts getContracts() {
        return contracts;
    }

    public void setContracts(Contracts contracts) {
        this.contracts = contracts;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
