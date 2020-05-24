package ru.kpfu.itis.shareholdersimulator.dao;

import ru.kpfu.itis.shareholdersimulator.entity.Balance;

import java.util.Optional;

public interface BalanceDaoService {

    Optional<Balance> getBalanceByLogin(String userLogin);

    Balance save(Balance balance);

}
