package ru.kpfu.itis.shareholdersimulator.dao.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import ru.kpfu.itis.shareholdersimulator.dao.DaoServiceTest;
import ru.kpfu.itis.shareholdersimulator.entity.User;
import ru.kpfu.itis.shareholdersimulator.repository.UserRepository;

import java.util.Optional;
import java.util.UUID;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserDaoServiceImplTest implements DaoServiceTest {

    @InjectMocks
    private UserDaoServiceImpl userDaoService;

    @InjectMocks
    private UserRepository userRepository;

    @Test
    public void findByLoginTest() {
        when(userRepository.findByLogin(Mockito.anyString())).thenReturn(Optional.of(new User()));

        User result = userDaoService.findByLogin(TEST_STRING);

        assertNotNull(result);
        verify(userRepository).findByLogin(Mockito.anyString());
    }

    @Test
    public void findByLoginTestFailed() {
        userDaoService.findByLogin(TEST_STRING);
    }

    @Test
    public void saveTest() {
        when(userRepository.save(Mockito.any(User.class))).thenReturn(new User());

        User result = userDaoService.save(new User());

        assertNotNull(result);
        verify(userRepository).save(Mockito.any(User.class));
    }

    @Test
    public void existByLoginTest() {
        when(userRepository.existsByLogin(Mockito.anyString())).thenReturn(true);

        boolean result = userDaoService.existByLogin(TEST_STRING);

        assertTrue(result);
        verify(userRepository).findByLogin(Mockito.anyString());
    }
}
