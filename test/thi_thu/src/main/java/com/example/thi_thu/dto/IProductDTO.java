package com.example.thi_thu.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface IProductDTO {
    Long getId();
    String getName();
    Long getPrice();
    LocalDateTime getCreateTime();
    LocalDateTime getUpdateTime();
    LocalDate getExpiredDate();
    Long getProductType();


}
