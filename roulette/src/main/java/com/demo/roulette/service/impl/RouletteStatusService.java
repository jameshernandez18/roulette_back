package com.demo.roulette.service.impl;

import com.demo.roulette.entity.RouletteStatus;
import com.demo.roulette.repository.RouletteSatusRepository;
import com.demo.roulette.service.IRouleteStatusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service("roulettestatusservice")
@Slf4j
public class RouletteStatusService implements IRouleteStatusService {


    @Autowired
    @Qualifier("roulettestatusRepository")
    private RouletteSatusRepository rouletteSatusRepository;

    @Override
    public RouletteStatus searchId(long id) {

        return rouletteSatusRepository.findById(id);
    }
}
