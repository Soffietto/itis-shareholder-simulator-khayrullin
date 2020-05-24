package ru.kpfu.itis.shareholdersimulator.service;

import ru.kpfu.itis.shareholdersimulator.dto.BalanceDto;
import ru.kpfu.itis.shareholdersimulator.entity.Balance;

public interface BalanceService {

    Double getCurrentUserBalanceAmount();

    Balance getCurrentUserBalance();

    Balance findByUserLogin(String userLogin);

    Balance saveNew(BalanceDto balanceDto);
}
