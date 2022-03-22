package com.demo.roulette.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "RO_ROULETTE")
public class Roulette implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RO_ROULETTE_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "RO_STATUS_ID_FK")
    private RouletteStatus idroulettestatus;
}
