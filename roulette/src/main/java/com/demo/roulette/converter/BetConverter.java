package com.demo.roulette.converter;

import com.demo.roulette.entity.Bet;
import com.demo.roulette.model.BetModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("betconverter")
public class BetConverter {
    public List<BetModel> listConverter(List<Bet> bets){
        List<BetModel> betModels = new ArrayList<>();
        bets.forEach(bet -> betModels.add(new BetModel(bet)));

        return betModels;
    }
}
