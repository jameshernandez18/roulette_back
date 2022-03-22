package com.demo.roulette.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "BE_BET")
public class Bet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BE_BET_ID")
    private long id;

    @Column(name = "BE_NUMBER")
    private String number;

    @Column(name = "BE_CREDIT")
    private String credit;

    @ManyToOne
    @JoinColumn(name = "BE_USER_ID_FK")
    private Users iduser;

    @ManyToOne
    @JoinColumn(name = "BE_ROULETTE_ID_FK")
    private Roulette  idroulette;
}
