package com.demo.roulette.repository;

import com.demo.roulette.entity.Users;
import com.demo.roulette.entity.WinUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("winsersRepository")
public interface WinUsersRepository extends JpaRepository<WinUsers, Long> {
    Users findById(long id);
    List<WinUsers> findByIdroulette(long idroulette);
}
