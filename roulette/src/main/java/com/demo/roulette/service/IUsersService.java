package com.demo.roulette.service;

import com.demo.roulette.entity.Users;
import com.demo.roulette.model.UsersModel;

import java.util.List;

public interface IUsersService {
    List<UsersModel> getAll();
    Users searchxiduser(long id);
}
