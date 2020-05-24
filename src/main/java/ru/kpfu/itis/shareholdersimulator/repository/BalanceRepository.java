package ru.kpfu.itis.shareholdersimulator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.shareholdersimulator.entity.Balance;

import java.util.Optional;
import java.util.UUID;

public interface BalanceRepository extends JpaRepository<Balance, UUID> {

    Optional<Balance> findBalanceByUserLogin(String userLogin);
}
