package com.demo.roulette.converter;

import com.demo.roulette.entity.Roulette;
import com.demo.roulette.model.RouletteModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("rouletteconverter")
public class RouletteConverter {
    public List<RouletteModel> listConverter(List<Roulette> rouletteslist){
        List<RouletteModel> rouletteModels = new ArrayList<>();
        rouletteslist.forEach(roulette -> rouletteModels.add(new RouletteModel(roulette)));

        return rouletteModels;
    }
}
