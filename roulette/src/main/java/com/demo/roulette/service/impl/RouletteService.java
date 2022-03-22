package com.demo.roulette.service.impl;

import com.demo.roulette.dto.RouletteDto;
import com.demo.roulette.entity.*;
import com.demo.roulette.repository.BetRepository;
import com.demo.roulette.service.IBetService;
import com.demo.roulette.service.IRouletteService;
import com.demo.roulette.config.GeneralFunctions;
import com.demo.roulette.converter.RouletteConverter;
import com.demo.roulette.dto.ResponseDto;
import com.demo.roulette.model.RouletteModel;
import com.demo.roulette.repository.RouletteRepository;
import com.demo.roulette.repository.UsersRepository;
import com.demo.roulette.service.IRouleteStatusService;
import com.demo.roulette.service.IWinUsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service("rouletteservice")
@Slf4j
public class RouletteService implements IRouletteService {


    @Autowired
    @Qualifier("rouletteRepository")
    private RouletteRepository rouletteRepository;

    @Autowired
    @Qualifier("betRepository")
    private BetRepository betRepository;

    @Autowired
    @Qualifier("usersRepository")
    private UsersRepository usersRepository;

    @Autowired
    @Qualifier("generalFunctions")
    private GeneralFunctions generalFunctions;

    @Autowired
    @Qualifier("winusersservice")
    private IWinUsersService iWinUsersService;

    @Autowired
    @Qualifier("roulettestatusservice")
    private IRouleteStatusService iRouleteStatusService;

    @Autowired
    @Qualifier("betservice")
    private IBetService iBetService;


    @Autowired
    @Qualifier("rouletteconverter")
    private RouletteConverter rouletteConverter;

    private int winMoney;


    @Override
    public List<RouletteModel> getAll() {
        List<Roulette> roulettes = rouletteRepository.findAll();
        return rouletteConverter.listConverter(roulettes);
    }


    @Override
    public Roulette searchxidroulette(long id) {
        return rouletteRepository.findById(id);
    }


    @Override
    public ResponseDto createRoulette(RouletteDto rouletteModel) {
        Roulette roulette = new Roulette();
        ResponseDto response;
        RouletteStatus rouletteStatus = this.iRouleteStatusService.searchId(rouletteModel.getIdroulettestatus());
        roulette.setIdroulettestatus(rouletteStatus);
        Roulette roulettes =  this.rouletteRepository.save(roulette);
        log.info("bet Created ID:{}",roulette.getId());
        response = this.generalFunctions.response(roulettes.getId(),
                HttpStatus.OK,
                "Se genero una nueva Ruleta de manera exitosa",
                "Created Equipment Class");

        return response;
    }

    @Override
    public ResponseDto openroulette(long idRoulette, RouletteDto rouletteModel) {
        ResponseDto response;
        Roulette roulette = rouletteRepository.getOne(idRoulette);
        RouletteStatus rouletteStatus = this.iRouleteStatusService.searchId(rouletteModel.getIdroulettestatus());
        roulette.setIdroulettestatus(rouletteStatus);
        Roulette roulettes =  this.rouletteRepository.save(roulette);
        log.info("bet Created ID:{}",roulette.getId());
        response = this.generalFunctions.response(roulettes.getId(),
                HttpStatus.OK,
                "Ruleta Habilitada",
                "Created Equipment Class");

        return response;
    }

    @Override
    public ResponseDto closeroulette(long idRoulette, RouletteDto rouletteModel) {
        ResponseDto response;
        int win = new Random().nextInt(36);
        Roulette roulette = rouletteRepository.getOne(idRoulette);
        RouletteStatus rouletteStatus = this.iRouleteStatusService.searchId(rouletteModel.getIdroulettestatus());
        roulette.setIdroulettestatus(rouletteStatus);
        Roulette roulettes =  this.rouletteRepository.save(roulette);
        List<Bet> betList =
                this.betRepository.findByIdrouletteAndNumber(roulettes,String.valueOf(win));
        if (!betList.isEmpty()) {
            Bet bet = this.iBetService.searchUserNumber(idRoulette,win);
            int creditUser = Integer.parseInt(bet.getCredit());
            winMoney = creditUser * 5;
            WinUsers winUsers = new WinUsers();
            winUsers.setIduser(bet.getIduser());
            winUsers.setCreditwin(String.valueOf(winMoney));
            winUsers.setIdroulette(bet.getIdroulette());
            this.iWinUsersService.createWinUser(winUsers);
            Users users =  usersRepository.getOne(bet.getIduser().getId());
            int accountCalculation = Integer.parseInt(users.getCredit()+winMoney);
            users.setCredit(String.valueOf(accountCalculation));
            this.usersRepository.save(users);
        }
        log.info("bet Created ID:{}",roulette.getId());
        response = this.generalFunctions.response(roulettes.getId(),
                HttpStatus.OK,
                "Ruleta Cerrada el numero ganador es :"+ win ,
                "Created Equipment Class");

        return response;
    }
}
