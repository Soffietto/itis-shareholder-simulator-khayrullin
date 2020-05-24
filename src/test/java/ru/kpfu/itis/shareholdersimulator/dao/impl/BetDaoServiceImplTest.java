package ru.kpfu.itis.shareholdersimulator.dao.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import ru.kpfu.itis.shareholdersimulator.dao.DaoServiceTest;
import ru.kpfu.itis.shareholdersimulator.entity.Bet;
import ru.kpfu.itis.shareholdersimulator.entity.User;
import ru.kpfu.itis.shareholdersimulator.entity.enums.BetStatus;
import ru.kpfu.itis.shareholdersimulator.repository.BetRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BetDaoServiceImplTest implements DaoServiceTest {

    @InjectMocks
    private BetDaoServiceImpl betDaoService;

    @Mock
    private BetRepository betRepository;

    @Test
    public void findAllByUserTest() {
        Bet bet = new Bet();
        when(betRepository.findAllByUserOrderByDateTimeDesc(Mockito.any(User.class)))
                .thenReturn(Collections.singletonList(bet));

        List<Bet> result = betDaoService.findAllByUser(new User());

        assertNotNull(result);
        Assert.assertEquals(Collections.singletonList(bet), result);
    }

    @Test
    public void saveTest() {
        when(betRepository.save(Mockito.any(Bet.class))).thenReturn(new Bet());

        Bet result = betDaoService.save(new Bet());

        assertNotNull(result);
        verify(betRepository).save(Mockito.any(Bet.class));
    }

    @Test
    public void findLatestDateByUserAndBetStatusTest() {
        when(betRepository.findFirstByUserAndBetStatusOrderByDateTimeAsc(Mockito.any(User.class), Mockito.any(BetStatus.class)))
                .thenReturn(Optional.of(new Bet()));

        Optional<Bet> result = betDaoService.findLatestDateByUserAndBetStatus(new User(), BetStatus.COMPLETE);

        assertTrue(result.isPresent());
        verify(betRepository).findFirstByUserAndBetStatusOrderByDateTimeAsc(Mockito.any(User.class), Mockito.any(BetStatus.class));
    }

    @Test
    public void findAllNewBetsTest() {
        when(betRepository.findAllByBetStatus(Mockito.any(BetStatus.class))).thenReturn(Collections.singletonList(new Bet()));

        List<Bet> result = betDaoService.findAllNewBets();

        assertNotNull(result);
        verify(betRepository).findAllByBetStatus(Mockito.any(BetStatus.class));
    }
}
