package ru.kpfu.itis.shareholdersimulator.dao.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import ru.kpfu.itis.shareholdersimulator.dao.DaoServiceTest;
import ru.kpfu.itis.shareholdersimulator.entity.Balance;
import ru.kpfu.itis.shareholdersimulator.repository.BalanceRepository;

import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BalanceDaoServiceImplTest implements DaoServiceTest {

    @InjectMocks
    private BalanceDaoServiceImpl balanceDaoService;

    @Mock
    private BalanceRepository balanceRepository;

    @Test
    public void getBalanceByLoginTest() {
        when(balanceRepository.findBalanceByUserLogin(Mockito.anyString()))
                .thenReturn(Optional.of(new Balance()));

        Optional<Balance> result = balanceDaoService.getBalanceByLogin(TEST_STRING);

        assertTrue(result.isPresent());
        verify(balanceRepository).findBalanceByUserLogin(Mockito.anyString());
    }

    @Test
    public void saveTest() {
        when(balanceRepository.save(Mockito.any(Balance.class))).thenReturn(new Balance());

        Balance result = balanceDaoService.save(new Balance());

        assertNotNull(result);
        verify(balanceRepository).save(Mockito.any(Balance.class));
    }
}
