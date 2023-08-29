package com.example.thi_thu.controller;


import com.example.thi_thu.model.PlayerModel;
import com.example.thi_thu.model.TeamModel;
import com.example.thi_thu.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/player")
public class PlayerRestController {
    @Autowired
    private IPlayerService iPlayerService;


    @Transactional
    @PostMapping("/create")
    public ResponseEntity<HttpStatus>createPlayer(@RequestBody PlayerModel playerModel){
        iPlayerService.create(playerModel);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping("/team-list")
    public ResponseEntity<List<TeamModel>>getList(){
       List<TeamModel> teamModelList = iPlayerService.getTeamList();
        if (teamModelList.size() == 0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(teamModelList, HttpStatus.OK);
    }
}
