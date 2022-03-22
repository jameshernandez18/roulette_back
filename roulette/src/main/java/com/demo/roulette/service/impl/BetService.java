package com.demo.roulette.service.impl;

import com.demo.roulette.dto.BetDto;
import com.demo.roulette.service.IBetService;
import com.demo.roulette.service.IRouletteService;
import com.demo.roulette.config.GeneralFunctions;
import com.demo.roulette.converter.BetConverter;
import com.demo.roulette.dto.ResponseDto;
import com.demo.roulette.entity.Bet;
import com.demo.roulette.entity.Roulette;
import com.demo.roulette.entity.Users;
import com.demo.roulette.model.BetModel;
import com.demo.roulette.repository.BetRepository;
import com.demo.roulette.repository.UsersRepository;
import com.demo.roulette.service.IUsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("betservice")
@Slf4j
public class BetService implements IBetService {

    @Autowired
    @Qualifier("rouletteservice")
    private IRouletteService iRouletteService;

    @Autowired
    @Qualifier("usersservice")
    private IUsersService iUsersService;

    @Autowired
    @Qualifier("betRepository")
    private BetRepository betRepository;

    @Autowired
    @Qualifier("betconverter")
    private BetConverter betConverter;

    @Autowired
    @Qualifier("generalFunctions")
    private GeneralFunctions generalFunctions;

    @Autowired
    @Qualifier("usersRepository")
    private UsersRepository usersRepository;


    @Override
    public List<BetModel> getAll() {
        List<Bet> bets = betRepository.findAll();

        return betConverter.listConverter(bets);
    }

    @Override
    public List<BetModel> searchbetxidroulette(long id){
        Roulette roulette = iRouletteService.searchxidroulette(id);
        List<Bet> roulettes = betRepository.findByIdroulette(roulette);

        return betConverter.listConverter(roulettes);
    }

    @Override
    public List<BetModel> searchbetIdrouletteAndNumber(long id){
        Roulette roulette = iRouletteService.searchxidroulette(id);
        List<Bet> roulettes = betRepository.findByIdroulette(roulette);

        return betConverter.listConverter(roulettes);
    }

    @Override
    public ResponseDto createBet(BetDto betModel) {
        Bet bet = new Bet();
        ResponseDto response;
        Users users = iUsersService.searchxiduser(betModel.getIduser());
        Roulette rouletteSearch = this.iRouletteService.searchxidroulette(betModel.getIdroulette());
        int creditUser = Integer.parseInt(users.getCredit());
        int creditBet = Integer.parseInt(betModel.getCredit());
        int numberBet = Integer.parseInt(betModel.getNumber());
        String balance= String.valueOf(creditUser-creditBet);
        if(creditBet > creditUser){
            response = this.generalFunctions.response(betModel.getIdroulette(),
                    HttpStatus.OK,
                    "El usuario no cuenta con el credito suficiente - credito disponible :" + users.getCredit(),
                    "Alert");

            return response;
        }
        if (numberBet > 36) {
            response = this.generalFunctions.response(betModel.getIdroulette(),
                    HttpStatus.OK,
                    "El numero no puede ser mayor a 36",
                    "Alert");

            return response;
        }
        if (creditBet > 10000) {
            response = this.generalFunctions.response(betModel.getIdroulette(),
                    HttpStatus.OK,
                    "La apuesta no puede ser mayor a 10.000",
                    "Alert");

            return response;
        }
        bet.setNumber(betModel.getNumber());
        bet.setCredit(betModel.getCredit());
        bet.setIdroulette(rouletteSearch);
        bet.setIduser(users);
        Bet bets =  this.betRepository.save(bet);
        users.setCredit(balance);
        this.usersRepository.save(users);
        log.info("bet Created ID:{}",bet.getId());
        response = this.generalFunctions.response(bets.getId(),
                HttpStatus.OK,
                "Apuesta Realizada de manera exitosa",
                "Created Equipment Class");

        return response;
    }

    @Override
    public Bet searchUserNumber(long idroulette, int number) {

        return betRepository.findByIdrouletteAndAndNumber(idroulette, String.valueOf(number) );
    }
}
