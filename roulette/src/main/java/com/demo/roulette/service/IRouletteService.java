package com.demo.roulette.service;


import com.demo.roulette.dto.ResponseDto;
import com.demo.roulette.dto.RouletteDto;
import com.demo.roulette.entity.Roulette;
import com.demo.roulette.model.RouletteModel;

import java.util.List;

public interface IRouletteService {
    List<RouletteModel> getAll();
    Roulette searchxidroulette(long id);
    ResponseDto createRoulette(RouletteDto rouletteModel);
    ResponseDto openroulette(long idRoulette, RouletteDto rouletteModel);
    ResponseDto closeroulette(long idRoulette, RouletteDto rouletteModel);
}
