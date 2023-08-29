package com.example.thi_thu.dto;

import java.time.LocalDate;

public interface IPlayerDTO {
    Long getId();
    String getName();
    LocalDate getBirthday();
    String getTeamModel();
    Integer getScoreTimes();


}
