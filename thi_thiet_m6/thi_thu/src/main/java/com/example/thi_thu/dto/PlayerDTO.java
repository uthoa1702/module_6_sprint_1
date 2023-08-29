package com.example.thi_thu.dto;

import java.time.LocalDate;

public class PlayerDTO {
    private Long id;

    private String name;

    private LocalDate birthday;

    private String teamModel;

    private Integer scoreTimes;

    public PlayerDTO() {
    }

    public PlayerDTO(Long id, String name, LocalDate birthday, String teamModel, Integer scoreTimes) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.teamModel = teamModel;
        this.scoreTimes = scoreTimes;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getTeamModel() {
        return teamModel;
    }

    public void setTeamModel(String teamModel) {
        this.teamModel = teamModel;
    }

    public Integer getScoreTimes() {
        return scoreTimes;
    }

    public void setScoreTimes(Integer scoreTimes) {
        this.scoreTimes = scoreTimes;
    }
}
