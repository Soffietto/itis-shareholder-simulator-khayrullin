package ru.kpfu.itis.shareholdersimulator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.shareholdersimulator.entity.Bet;
import ru.kpfu.itis.shareholdersimulator.entity.User;
import ru.kpfu.itis.shareholdersimulator.entity.enums.BetStatus;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BetRepository extends JpaRepository<Bet, UUID> {

    Optional<Bet> findFirstByUserAndBetStatusOrderByDateTimeAsc(User user, BetStatus betStatus);

    List<Bet> findAllByBetStatus(BetStatus betStatus);

    List<Bet> findAllByUserOrderByDateTimeDesc(User user);
}
