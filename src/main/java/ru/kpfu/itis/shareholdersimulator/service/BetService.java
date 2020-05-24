package ru.kpfu.itis.shareholdersimulator.service;

import ru.kpfu.itis.shareholdersimulator.entity.Bet;

import java.util.List;

public interface BetService {
    List<Bet> getCurrentUserBets();
}
