package com.demo.roulette.controller;


import com.demo.roulette.model.UsersModel;
import com.demo.roulette.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/user")
@CrossOrigin(origins = "*")
@Validated
public class UsersController {

    @Autowired
    private IUsersService iUsersService;

    @GetMapping
    public List<UsersModel> getAll() {

        return iUsersService.getAll();
    }

}
