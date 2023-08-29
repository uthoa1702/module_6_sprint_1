package com.example.thi_thu.service;

import com.example.thi_thu.dto.PlayerDTO;
import com.example.thi_thu.model.Penalty;
import com.example.thi_thu.model.PlayerModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPenaltyService {
    Page<Penalty> getList(Pageable pageable, String name);

    void delete(Long id);

    List<PlayerDTO> top5();

}
