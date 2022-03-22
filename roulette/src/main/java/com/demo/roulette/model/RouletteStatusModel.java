package com.demo.roulette.model;

import com.demo.roulette.entity.RouletteStatus;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class RouletteStatusModel {
    private long id;
    private String description;
    public RouletteStatusModel(RouletteStatus rouletteStatus) {
        this.id=rouletteStatus.getId();
        this.description=rouletteStatus.getDescription();
    }
}
