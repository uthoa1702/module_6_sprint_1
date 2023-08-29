package com.example.thi_thu.service;

import com.example.thi_thu.model.PlayerModel;
import com.example.thi_thu.model.TeamModel;

import java.util.List;

public interface IPlayerService {
    void create(PlayerModel playerModel);

    List<TeamModel> getTeamList();

}
