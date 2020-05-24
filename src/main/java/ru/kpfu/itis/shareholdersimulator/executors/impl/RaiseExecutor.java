package ru.kpfu.itis.shareholdersimulator.executors.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.shareholdersimulator.entity.Bet;
import ru.kpfu.itis.shareholdersimulator.executors.Executor;
import ru.kpfu.itis.shareholdersimulator.service.StocksService;

@Component
@Qualifier("raiseExecutor")
@RequiredArgsConstructor
public class RaiseExecutor implements Executor {

    private final StocksService stocksService;

    @Override
    public boolean isWon(Bet bet) {
        return stocksService.isRaise();
    }
}
