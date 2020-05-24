package ru.kpfu.itis.shareholdersimulator.dao.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.shareholdersimulator.dao.BalanceDaoService;
import ru.kpfu.itis.shareholdersimulator.entity.Balance;
import ru.kpfu.itis.shareholdersimulator.repository.BalanceRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BalanceDaoServiceImpl implements BalanceDaoService {

    private final BalanceRepository balanceRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<Balance> getBalanceByLogin(String userLogin) {
        return balanceRepository.findBalanceByUserLogin(userLogin);
    }

    @Override
    @Transactional
    public Balance save(Balance balance) {
        return balanceRepository.save(balance);
    }
}
