package com.example.thi_thu.service.impl;

import com.example.thi_thu.model.PlayerModel;
import com.example.thi_thu.model.TeamModel;
import com.example.thi_thu.repository.IPlayerRepository;
import com.example.thi_thu.repository.ITeamRepository;
import com.example.thi_thu.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements IPlayerService {
    @Autowired
    private IPlayerRepository iPlayerRepository;

    @Autowired private ITeamRepository iTeamRepository;

    @Override
    public void create(PlayerModel playerModel) {
        iPlayerRepository.save(playerModel);
    }

    @Override
    public List<TeamModel> getTeamList() {
        return iTeamRepository.findAll();
    }
}
