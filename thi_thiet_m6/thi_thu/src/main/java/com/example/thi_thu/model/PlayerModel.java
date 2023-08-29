package com.example.thi_thu.model;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class PlayerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private LocalDate birthday;

    @ManyToOne
    @JoinColumn(name = "team_model_id")
    private TeamModel teamModel;

    public PlayerModel() {
    }

    public PlayerModel(Long id) {
        this.id = id;
    }

    public PlayerModel(String name, LocalDate birthday, TeamModel teamModel) {
        this.name = name;
        this.birthday = birthday;
        this.teamModel = teamModel;
    }

    public PlayerModel(Long id, String name, LocalDate birthday, TeamModel teamModel) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.teamModel = teamModel;
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

    public TeamModel getTeamModel() {
        return teamModel;
    }

    public void setTeamModel(TeamModel teamModel) {
        this.teamModel = teamModel;
    }
}
