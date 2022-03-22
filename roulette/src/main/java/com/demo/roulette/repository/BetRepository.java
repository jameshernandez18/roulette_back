package com.demo.roulette.repository;

import com.demo.roulette.entity.Bet;
import com.demo.roulette.entity.Roulette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("betRepository")
public interface BetRepository extends JpaRepository<Bet, Long> {
    List<Bet> findByIdroulette (Roulette id);
    List<Bet> findByIdrouletteAndNumber (Roulette id, String number );
    Bet findByIdrouletteAndAndNumber(long idRoulette, String number);
}
