package com.demo.roulette.repository;

import com.demo.roulette.entity.Roulette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("rouletteRepository")
public interface RouletteRepository extends JpaRepository<Roulette, Long> {
    Roulette findById (long id);
}
