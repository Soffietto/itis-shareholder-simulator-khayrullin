package ru.kpfu.itis.shareholdersimulator.mapper.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kpfu.itis.shareholdersimulator.dto.RegisterDto;
import ru.kpfu.itis.shareholdersimulator.entity.User;
import ru.kpfu.itis.shareholdersimulator.mapper.EntityMapperTest;
import ru.kpfu.itis.shareholdersimulator.mapper.UserEntityMapper;
import ru.kpfu.itis.shareholdersimulator.mapper.UserEntityMapperImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserEntityMapperImpl.class)
public class UserEntityMapperTest implements EntityMapperTest {

    @Autowired
    private UserEntityMapper mapper;

    @Test
    public void toEntityTest() {
        RegisterDto registerDto = new RegisterDto();
        registerDto.setName(TEST_STRING);
        registerDto.setLogin(TEST_STRING);
        registerDto.setPassword(TEST_STRING);

        User result = mapper.toEntity(registerDto);

        assertNotNull(result);
        assertEquals(result.getLogin(), registerDto.getLogin());
        assertEquals(result.getName(), registerDto.getName());
    }
}
