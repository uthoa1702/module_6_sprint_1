package com.example.thi_thu.controller;

import com.example.thi_thu.dto.PlayerDTO;
import com.example.thi_thu.model.Penalty;
import com.example.thi_thu.model.PlayerModel;
import com.example.thi_thu.service.IPenaltyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/penalty")
public class PenaltyRestController {
    @Autowired
    private IPenaltyService iPenaltyService;


    @GetMapping("/list")
    public ResponseEntity<Page<Penalty>> getPenPage(@RequestParam(value = "page", defaultValue = "0")Integer page,
                                                    @RequestParam(value = "name") String name){
        Pageable pageable = PageRequest.of(page, 5);
        Page<Penalty> penaltyPage = iPenaltyService.getList(pageable, name);
        if (penaltyPage == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(penaltyPage, HttpStatus.OK);

    }

    @GetMapping("/top5")
    public ResponseEntity<List<PlayerDTO>> getTop5 (){
        List<PlayerDTO> playerModelList = iPenaltyService.top5();
        if (playerModelList.size() == 0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }
        return new ResponseEntity<>(playerModelList, HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/delete")
    public ResponseEntity<HttpStatus> delete(@RequestParam(value = "id")Long id){
        if (id == null || id == 0 ){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        iPenaltyService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
