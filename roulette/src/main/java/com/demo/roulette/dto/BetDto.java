package com.demo.roulette.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BetDto {
    private String number;
    private String credit;
    private long iduser;
    private long idroulette;
}
