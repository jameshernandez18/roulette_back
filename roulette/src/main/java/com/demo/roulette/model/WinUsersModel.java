package com.demo.roulette.model;

import com.demo.roulette.entity.Roulette;
import com.demo.roulette.entity.Users;
import com.demo.roulette.entity.WinUsers;
import lombok.AllArgsConstructor;
import lombok.Data;



@Data
@AllArgsConstructor
public class WinUsersModel {
    private long id;
    private String creditwin;
    private Users iduser;
    private Roulette idroulette;
    public WinUsersModel(WinUsers winUsers) {
        this.id=winUsers.getId();
        this.creditwin=winUsers.getCreditwin();
        this.iduser=winUsers.getIduser();
        this.idroulette= winUsers.getIdroulette();
    }
}
