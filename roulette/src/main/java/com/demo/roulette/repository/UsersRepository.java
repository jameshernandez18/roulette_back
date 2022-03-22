package com.demo.roulette.repository;

import com.demo.roulette.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("usersRepository")
public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findById(long id);
}
