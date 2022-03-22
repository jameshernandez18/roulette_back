package com.demo.roulette.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "US_USERS")
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "US_ID")
    private long id;

    @Column(name = "US_CREDIT")
    private String credit;

    @Column(name = "US_USER_NAME")
    private String username;
}
