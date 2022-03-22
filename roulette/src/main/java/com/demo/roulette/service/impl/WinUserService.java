package com.demo.roulette.service.impl;

import com.demo.roulette.config.GeneralFunctions;
import com.demo.roulette.converter.WinUsersConverter;
import com.demo.roulette.dto.ResponseDto;
import com.demo.roulette.entity.WinUsers;
import com.demo.roulette.model.WinUsersModel;
import com.demo.roulette.repository.WinUsersRepository;
import com.demo.roulette.service.IWinUsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("winusersservice")
@Slf4j
public class WinUserService implements IWinUsersService {


    @Autowired
    @Qualifier("winsersRepository")
    private WinUsersRepository winUsersRepository;

    @Autowired
    @Qualifier("winusersconverter")
    private WinUsersConverter winUsersConverter;

    @Autowired
    @Qualifier("generalFunctions")
    private GeneralFunctions generalFunctions;


    @Override
    public List<WinUsersModel> getUserWin(long idRoulette) {
        List<WinUsers> winUsers = winUsersRepository.findByIdroulette(idRoulette);

        return winUsersConverter.listConverter(winUsers);
    }


    @Override
    public ResponseDto createWinUser(WinUsers winUsers) {
        ResponseDto response;
        WinUsers winUserss =  this.winUsersRepository.save(winUsers);
        response = this.generalFunctions.response(winUserss.getId(),
                HttpStatus.OK,
                "Se ingresa registro del ganador",
                "Created Equipment Class");

        return response;
    }


}
