package ru.kpfu.itis.shareholdersimulator.executors;

import ru.kpfu.itis.shareholdersimulator.entity.Bet;

public interface Executor {

    boolean isWon(Bet bet);
}
