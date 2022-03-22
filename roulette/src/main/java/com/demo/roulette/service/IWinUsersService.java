package com.demo.roulette.service;

import com.demo.roulette.dto.ResponseDto;
import com.demo.roulette.entity.WinUsers;
import com.demo.roulette.model.WinUsersModel;

import java.util.List;

public interface IWinUsersService {
    List<WinUsersModel> getUserWin(long idRoulette);
    ResponseDto createWinUser(WinUsers winUsers);
}
