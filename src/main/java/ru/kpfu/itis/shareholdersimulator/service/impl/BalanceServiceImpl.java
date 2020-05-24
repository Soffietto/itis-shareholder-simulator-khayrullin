package ru.kpfu.itis.shareholdersimulator.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.shareholdersimulator.dao.BalanceDaoService;
import ru.kpfu.itis.shareholdersimulator.dto.BalanceDto;
import ru.kpfu.itis.shareholdersimulator.entity.Balance;
import ru.kpfu.itis.shareholdersimulator.security.AuthDataHolder;
import ru.kpfu.itis.shareholdersimulator.service.BalanceService;

@Service
@RequiredArgsConstructor
public class BalanceServiceImpl implements BalanceService {

    private final BalanceDaoService balanceDaoService;
    private final AuthDataHolder authDataHolder;

    @Override
    public Double getCurrentUserBalanceAmount() {
        return getCurrentUserBalance().getAmount();
    }

    @Override
    public Balance getCurrentUserBalance() {
        return findByUserLogin(authDataHolder.getUser().getLogin());
    }

    @Override
    public Balance findByUserLogin(String userLogin) {
        return balanceDaoService.getBalanceByLogin(userLogin)
                .orElseGet(Balance::new);
    }

    @Override
    public Balance saveNew(BalanceDto balanceDto) {
        Balance currentBalance = getCurrentUserBalance();
        currentBalance.setAmount(currentBalance.getAmount() + balanceDto.getAdditionalBalance());
        return balanceDaoService.save(currentBalance);
    }
}
