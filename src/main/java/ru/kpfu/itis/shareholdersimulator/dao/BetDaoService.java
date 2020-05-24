package ru.kpfu.itis.shareholdersimulator.dao;

import ru.kpfu.itis.shareholdersimulator.entity.Bet;
import ru.kpfu.itis.shareholdersimulator.entity.User;
import ru.kpfu.itis.shareholdersimulator.entity.enums.BetStatus;

import java.util.List;
import java.util.Optional;

public interface BetDaoService {

    List<Bet> findAllByUser(User user);

    Bet save(Bet bet);

    Optional<Bet> findLatestDateByUserAndBetStatus(User user, BetStatus betStatus);

    List<Bet> findAllNewBets();
}
