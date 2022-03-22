package com.demo.roulette.service;




import com.demo.roulette.dto.BetDto;
import com.demo.roulette.dto.ResponseDto;
import com.demo.roulette.entity.Bet;
import com.demo.roulette.model.BetModel;

import java.util.List;

public interface IBetService {
    List<BetModel> getAll();
    List<BetModel> searchbetxidroulette(long id);
    List<BetModel> searchbetIdrouletteAndNumber(long id);
    ResponseDto createBet(BetDto betModel);
    Bet searchUserNumber(long idroulette, int number);
}
