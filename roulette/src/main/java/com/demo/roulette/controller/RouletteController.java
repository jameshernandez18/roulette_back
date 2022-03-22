package com.demo.roulette.controller;


import com.demo.roulette.dto.ResponseDto;
import com.demo.roulette.dto.RouletteDto;
import com.demo.roulette.model.RouletteModel;
import com.demo.roulette.service.IRouletteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/v1/roulette")
@CrossOrigin(origins = "*")
@Validated
public class RouletteController {

    @Autowired
    private IRouletteService iRouletteService;

    @GetMapping
    public List<RouletteModel> getAll() {

        return iRouletteService.getAll();
    }

    @PostMapping("/create")
    public ResponseDto create(@RequestBody @Valid RouletteDto rouletteModel) {

        return iRouletteService.createRoulette(rouletteModel);
    }

    @PutMapping("/open/{idRoulette}")
    public ResponseDto open(@PathVariable(name = "idRoulette") long idRoulette,
                              @RequestBody RouletteDto rouletteModel) {

        return iRouletteService.openroulette(idRoulette, rouletteModel);
    }

    @PutMapping("/close/{idRoulette}")
    public ResponseDto close(@PathVariable(name = "idRoulette") long idRoulette,
                            @RequestBody RouletteDto rouletteModel) {

        return iRouletteService.closeroulette(idRoulette, rouletteModel);
    }

}
