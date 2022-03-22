package com.demo.roulette.converter;

import com.demo.roulette.entity.Users;
import com.demo.roulette.model.UsersModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("usersconverter")
public class UsersConverter {
    public List<UsersModel> listConverter(List<Users> users){
        List<UsersModel> userModels = new ArrayList<>();
        users.forEach(user -> userModels.add(new UsersModel(user)));

        return userModels;
    }
}
