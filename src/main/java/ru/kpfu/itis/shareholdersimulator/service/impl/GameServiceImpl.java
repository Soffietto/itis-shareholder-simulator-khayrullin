package ru.kpfu.itis.shareholdersimulator.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.shareholdersimulator.dao.BetDaoService;
import ru.kpfu.itis.shareholdersimulator.dao.BetTypeDaoService;
import ru.kpfu.itis.shareholdersimulator.entity.Bet;
import ru.kpfu.itis.shareholdersimulator.entity.BetType;
import ru.kpfu.itis.shareholdersimulator.entity.enums.BetStatus;
import ru.kpfu.itis.shareholdersimulator.exception.BetMakingException;
import ru.kpfu.itis.shareholdersimulator.executors.ExecutorManager;
import ru.kpfu.itis.shareholdersimulator.security.AuthDataHolder;
import ru.kpfu.itis.shareholdersimulator.service.BalanceService;
import ru.kpfu.itis.shareholdersimulator.service.GameService;
import ru.kpfu.itis.shareholdersimulator.service.StocksService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final ExecutorManager executorManager;
    private final AuthDataHolder authDataHolder;
    private final BetTypeDaoService betTypeDaoService;
    private final BetDaoService betDaoService;
    private final StocksService stocksService;
    private final BalanceService balanceService;

    @Override
    public boolean makeBet(double amount, UUID betTypeId) {
        if (balanceService.getCurrentUserBalanceAmount() < amount || amount <= 0) {
            throw new BetMakingException("Укажите корректный баланс");
        }
        BetType betType = betTypeDaoService.findById(betTypeId);
        Bet bet = getNewBet(betType, amount);
        betDaoService.save(bet);
        return true;
    }

    @Override
    public List<Bet> getCurrentUserBets() {
        return betDaoService.findAllByUser(authDataHolder.getUser());
    }

    @Override
    public boolean isAlreadyInGame() {
        return betDaoService.findLatestDateByUserAndBetStatus(
                authDataHolder.getUser(),
                BetStatus.PREPARATION
        ).isPresent();
    }

    @Scheduled(fixedDelay = 15 * 1000)
    private void updateBets() {
        List<Bet> bets = betDaoService.findAllNewBets();
        executorManager.execute(bets);
    }

    private Bet getNewBet(BetType betType, double amount) {
        return Bet.builder()
                .betType(betType)
                .amount(amount)
                .dateTime(LocalDateTime.now())
                .user(authDataHolder.getUser())
                .actualStockValue(stocksService.getCurrentStockValue())
                .betStatus(BetStatus.PREPARATION)
                .build();
    }

}
