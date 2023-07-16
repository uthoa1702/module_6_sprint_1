package com.example.demo.controller;

import com.example.back_end.service.IRedeemingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/employee/redeem")
@CrossOrigin("*")
public class RedeemingController {
    @Autowired
    private IRedeemingService iRedeemingService;


    @Transactional
    @PatchMapping("/{id}")
    public void redeem(@PathVariable("id") Long id) {
        iRedeemingService.redeem(id);
    }
}
