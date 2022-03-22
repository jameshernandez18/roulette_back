package com.demo.roulette.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "WU_WIN_USERS")
public class WinUsers implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WU_WIN_ID")
    private long id;

    @Column(name = "WU_WIN_CREDIT")
    private String creditwin;

    @ManyToOne
    @JoinColumn(name = "WU_USER_ID_FK")
    private Users iduser;

    @ManyToOne
    @JoinColumn(name = "WU_ROULETTE_ID_FK")
    private Roulette  idroulette;
}
