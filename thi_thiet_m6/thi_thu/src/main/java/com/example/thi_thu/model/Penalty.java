package com.example.thi_thu.model;

import javax.persistence.*;

@Entity
public class Penalty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_model_id")
    private PlayerModel playerModel;


    private Integer area;



    private boolean result;

    @Column(name = "is_delete" , columnDefinition = "BIT DEFAULT 0")
    private boolean isDelete;

    public Penalty() {
    }

    public Penalty(Long id, PlayerModel playerModel, Integer area, boolean result, boolean isDelete) {
        this.id = id;
        this.playerModel = playerModel;
        this.area = area;
        this.result = result;
        this.isDelete = isDelete;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public Penalty(PlayerModel playerModel, Integer area, boolean result) {
        this.playerModel = playerModel;
        this.area = area;
        this.result = result;
    }

    public Penalty(Long id) {
        this.id = id;
    }

    public Penalty(Long id, PlayerModel playerModel, Integer area) {
        this.id = id;
        this.playerModel = playerModel;
        this.area = area;
    }

    public Penalty(PlayerModel playerModel, Integer area) {
        this.playerModel = playerModel;
        this.area = area;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PlayerModel getPlayerModel() {
        return playerModel;
    }

    public void setPlayerModel(PlayerModel playerModel) {
        this.playerModel = playerModel;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Penalty(Long id, PlayerModel playerModel, Integer area, boolean isDelete) {
        this.id = id;
        this.playerModel = playerModel;
        this.area = area;
        this.isDelete = isDelete;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
