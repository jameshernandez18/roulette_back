package com.demo.roulette.model;

import com.demo.roulette.entity.Roulette;
import com.demo.roulette.entity.RouletteStatus;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class RouletteModel {
    private long id;
    private RouletteStatus idroulettestatus;
    public RouletteModel(Roulette roulette) {
        this.id=roulette.getId();
        this.idroulettestatus=roulette.getIdroulettestatus();
    }
}
