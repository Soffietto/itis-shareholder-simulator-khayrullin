package ru.kpfu.itis.shareholdersimulator.dao.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.shareholdersimulator.dao.BetDaoService;
import ru.kpfu.itis.shareholdersimulator.entity.Bet;
import ru.kpfu.itis.shareholdersimulator.entity.User;
import ru.kpfu.itis.shareholdersimulator.entity.enums.BetStatus;
import ru.kpfu.itis.shareholdersimulator.repository.BetRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BetDaoServiceImpl implements BetDaoService {

    private final BetRepository betRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Bet> findAllByUser(User user) {
        return betRepository.findAllByUserOrderByDateTimeDesc(user);
    }

    @Override
    @Transactional
    public Bet save(Bet bet) {
        return betRepository.save(bet);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Bet> findLatestDateByUserAndBetStatus(User user, BetStatus betStatus) {
        return betRepository.findFirstByUserAndBetStatusOrderByDateTimeAsc(user, betStatus);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Bet> findAllNewBets() {
        return betRepository.findAllByBetStatus(BetStatus.PREPARATION);
    }
}
