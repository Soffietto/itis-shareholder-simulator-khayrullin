package ru.kpfu.itis.shareholdersimulator.dao.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import ru.kpfu.itis.shareholdersimulator.dao.DaoServiceTest;
import ru.kpfu.itis.shareholdersimulator.entity.BetType;
import ru.kpfu.itis.shareholdersimulator.exception.NotFoundInDbException;
import ru.kpfu.itis.shareholdersimulator.repository.BetTypeRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BetTypeDaoServiceImplTest implements DaoServiceTest {

    @InjectMocks
    private BetTypeDaoServiceImpl betTypeDaoService;

    @Mock
    private BetTypeRepository betTypeRepository;

    @Test
    public void findAllTest() {
        when(betTypeRepository.findAll()).thenReturn(Collections.singletonList(new BetType()));

        List<BetType> result = betTypeDaoService.findAll();

        assertNotNull(result);
        verify(betTypeRepository).findAll();
    }

    @Test
    public void findByIdTest() {
        when(betTypeRepository.findById(Mockito.any(UUID.class))).thenReturn(Optional.of(new BetType()));

        BetType result = betTypeDaoService.findById(UUID.randomUUID());

        assertNotNull(result);
        verify(betTypeRepository).findById(Mockito.any(UUID.class));
    }

    @Test(expected = NotFoundInDbException.class)
    public void findByIdTestFailed() {
        betTypeDaoService.findById(UUID.randomUUID());
    }
}
