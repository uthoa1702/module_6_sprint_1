package com.example.thi_thu.dto;

import java.time.LocalDate;

public interface IOrdersDTO {
    Long getId();
    Double getTotal();
    Integer getAmount();
    String getCustomerName();
    LocalDate getExpiredDate();

}
