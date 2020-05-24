package ru.kpfu.itis.shareholdersimulator.service;

import ru.kpfu.itis.shareholdersimulator.entity.Bet;

import java.util.List;
import java.util.UUID;

public interface GameService {

    boolean makeBet(double amount, UUID betTypeId);

    List<Bet> getCurrentUserBets();

    boolean isAlreadyInGame();

}
