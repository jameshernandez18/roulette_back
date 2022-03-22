package com.demo.roulette.service.impl;

import com.demo.roulette.config.GeneralFunctions;
import com.demo.roulette.converter.UsersConverter;
import com.demo.roulette.entity.Users;
import com.demo.roulette.model.UsersModel;
import com.demo.roulette.service.IRouletteService;
import com.demo.roulette.repository.UsersRepository;
import com.demo.roulette.service.IUsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("usersservice")
@Slf4j
public class UsersService implements IUsersService {

    @Autowired
    @Qualifier("rouletteservice")
    private IRouletteService iRouletteService;

    @Autowired
    @Qualifier("usersRepository")
    private UsersRepository usersRepository;

    @Autowired
    @Qualifier("usersconverter")
    private UsersConverter usersConverter;

    @Autowired
    @Qualifier("generalFunctions")
    private GeneralFunctions generalFunctions;


    @Override
    public List<UsersModel> getAll() {
        List<Users> users = usersRepository.findAll();

        return usersConverter.listConverter(users);
    }

    @Override
    public Users searchxiduser(long id) {

        return usersRepository.findById(id);
    }
}
