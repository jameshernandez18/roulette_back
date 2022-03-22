package com.demo.roulette.converter;

import com.demo.roulette.entity.WinUsers;
import com.demo.roulette.model.WinUsersModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("winusersconverter")
public class WinUsersConverter {
    public List<WinUsersModel> listConverter(List<WinUsers> winUsers){
        List<WinUsersModel> winUsersModels = new ArrayList<>();
        winUsers.forEach(user -> winUsersModels.add(new WinUsersModel(user)));

        return winUsersModels;
    }
}
