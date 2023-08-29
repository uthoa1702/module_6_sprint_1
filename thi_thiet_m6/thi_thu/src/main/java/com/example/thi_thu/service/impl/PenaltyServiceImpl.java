package com.example.thi_thu.service.impl;

import com.example.thi_thu.dto.IPlayerDTO;
import com.example.thi_thu.dto.PlayerDTO;
import com.example.thi_thu.model.Penalty;
import com.example.thi_thu.model.PlayerModel;
import com.example.thi_thu.repository.IPenaltyRepository;
import com.example.thi_thu.repository.IPlayerRepository;
import com.example.thi_thu.service.IPenaltyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PenaltyServiceImpl implements IPenaltyService {
    @Autowired private IPenaltyRepository iPenaltyRepository;
    @Autowired private IPlayerRepository iPlayerRepository;

    @Override
    public Page<Penalty> getList(Pageable pageable, String name) {
        return iPenaltyRepository.findAllPen(pageable, "%" + name + "%");
    }

    @Override
    public void delete(Long id) {
        iPenaltyRepository.deletePen(id);
    }

    @Override
    public List<PlayerDTO> top5() {
        List<IPlayerDTO> playerDTOList = iPlayerRepository.getList();
        return transformDTO(playerDTOList);
    }

    private List<PlayerDTO> transformDTO(List<IPlayerDTO> iPlayerDTOS){
        List<PlayerDTO> playerDTOList = new ArrayList<>();
        for (int i = 0; i < iPlayerDTOS.size(); i++) {
            PlayerDTO playerDTO = new PlayerDTO();
            playerDTO.setId(iPlayerDTOS.get(i).getId());
            playerDTO.setName(iPlayerDTOS.get(i).getName());
            playerDTO.setScoreTimes(iPlayerDTOS.get(i).getScoreTimes());
            playerDTO.setTeamModel(iPlayerDTOS.get(i).getTeamModel());
            playerDTOList.add(playerDTO);
        }
        return playerDTOList;
    }
}
