package com.example.thi_thu.model;

import javax.persistence.*;

@Entity
public class TeamModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String coachName;

    public TeamModel() {
    }

    public TeamModel(Long id) {
        this.id = id;
    }

    public TeamModel(Long id, String name, String coachName) {
        this.id = id;
        this.name = name;
        this.coachName = coachName;
    }

    public TeamModel(String name, String coachName) {
        this.name = name;
        this.coachName = coachName;
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

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }
}
