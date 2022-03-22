package com.demo.roulette.model;

import com.demo.roulette.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class UsersModel {
    private long id;
    private String credit;
    private String username;
    public UsersModel(Users users) {
        this.id=users.getId();
        this.credit=users.getCredit();
        this.username=users.getUsername();
    }
}
