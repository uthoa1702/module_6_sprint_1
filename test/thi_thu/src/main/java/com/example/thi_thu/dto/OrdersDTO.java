package com.example.thi_thu.dto;

import java.time.LocalDate;

public class OrdersDTO {
    private Long id;

    private Double total;

    private Integer amount;

    private String customerName;

    private LocalDate expiredDate;

    public OrdersDTO() {
    }

    public OrdersDTO(Long id) {
        this.id = id;
    }

    public OrdersDTO(Long id, Double total, Integer amount, String customerName, LocalDate expiredDate) {
        this.id = id;
        this.total = total;
        this.amount = amount;
        this.customerName = customerName;
        this.expiredDate = expiredDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(LocalDate expiredDate) {
        this.expiredDate = expiredDate;
    }
}
