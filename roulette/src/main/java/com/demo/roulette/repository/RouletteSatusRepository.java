package com.demo.roulette.repository;

import com.demo.roulette.entity.RouletteStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("roulettestatusRepository")
public interface RouletteSatusRepository extends JpaRepository<RouletteStatus, Long> {
    RouletteStatus findById(long id);
}
