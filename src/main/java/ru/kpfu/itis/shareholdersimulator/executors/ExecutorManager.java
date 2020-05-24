package ru.kpfu.itis.shareholdersimulator.executors;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.shareholdersimulator.dao.BalanceDaoService;
import ru.kpfu.itis.shareholdersimulator.dao.BetDaoService;
import ru.kpfu.itis.shareholdersimulator.entity.Balance;
import ru.kpfu.itis.shareholdersimulator.entity.Bet;
import ru.kpfu.itis.shareholdersimulator.entity.enums.BetStatus;
import ru.kpfu.itis.shareholdersimulator.exception.NotFoundInDbException;
import ru.kpfu.itis.shareholdersimulator.service.StocksService;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class ExecutorManager {

    private final ExecutorSwitcher executorSwitcher;
    private final BalanceDaoService balanceDaoService;
    private final BetDaoService betDaoService;
    private final StocksService stocksService;

    public void execute(List<Bet> bets) {
        log.info("Executing bets. Count:" + bets.size());
        bets.forEach(bet -> {
            log.info("-------------------------------------------------------------------");
            log.info("Executing start bet: " + bet);
            Executor executor = executorSwitcher.getExecutor(bet.getBetType().getBetType());
            Balance balance = balanceDaoService.getBalanceByLogin(bet.getUser().getLogin())
                    .orElseThrow(NotFoundInDbException::new);
            boolean won = executor.isWon(bet);
            if (won) {
                balance.addAmount(bet.getAmount() * 2);
            } else {
                balance.subtractAmount(bet.getAmount());
            }
            bet.setBetStatus(BetStatus.COMPLETE);
            bet.setWin(won);
            bet.setActualStockValue(stocksService.getCurrentStockValue());
            betDaoService.save(bet);
            balanceDaoService.save(balance);
            log.info("Executing finished bet: " + bet);
        });
    }
}
