package com.demo.roulette.model;

import com.demo.roulette.entity.Roulette;
import com.demo.roulette.entity.Users;
import com.demo.roulette.entity.Bet;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class BetModel {
    private long id;
    private String number;
    private String credit;
    private Users iduser;
    private Roulette idroulette;
    public BetModel(Bet bet) {
        this.id=bet.getId();
        this.number=bet.getNumber();
        this.credit=bet.getCredit();
        this.iduser=bet.getIduser();
        this.idroulette= bet.getIdroulette();
    }
}
