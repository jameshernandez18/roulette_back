package com.demo.roulette.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "RS_ROULETTE_STATUS")
public class RouletteStatus implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RG_STATUS_ID")
    private long id;

    @Column(name = "RG_DESCRIPTION")
    private String description;
}
