package com.demo.roulette.controller;


import com.demo.roulette.dto.BetDto;
import com.demo.roulette.service.IBetService;
import com.demo.roulette.dto.ResponseDto;
import com.demo.roulette.model.BetModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/v1/bet")
@CrossOrigin(origins = "*")
@Validated
public class BetController {

    @Autowired
    private IBetService iBetService;

    @GetMapping
    public List<BetModel> getAll() {

        return iBetService.getAll();
    }


    @GetMapping("/id/{id}")
    public List<BetModel> buscarCaiftthx0t (@PathVariable(value = "id") long id){

        return iBetService.searchbetxidroulette(id);
    }

    @PostMapping("/create")
    public ResponseDto create(@RequestBody @Valid BetDto betModel) {

        return iBetService.createBet(betModel);
    }

}
