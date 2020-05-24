package ru.kpfu.itis.shareholdersimulator.mapper.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kpfu.itis.shareholdersimulator.dto.BetTypeViewDto;
import ru.kpfu.itis.shareholdersimulator.entity.BetType;
import ru.kpfu.itis.shareholdersimulator.entity.enums.BetTypes;
import ru.kpfu.itis.shareholdersimulator.mapper.BetTypeEntityMapper;
import ru.kpfu.itis.shareholdersimulator.mapper.BetTypeEntityMapperImpl;
import ru.kpfu.itis.shareholdersimulator.mapper.EntityMapperTest;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BetTypeEntityMapperImpl.class)
public class BetTypeEntityMapperTest implements EntityMapperTest {

    @Autowired
    private BetTypeEntityMapper mapper;

    @Test
    public void toDtoTest() {
        BetType betType = new BetType();
        betType.setName(TEST_STRING);
        betType.setBetType(BetTypes.RAISE);

        List<BetTypeViewDto> result = mapper.toDto(Collections.singletonList(betType));

        assertNotNull(result);
        assertEquals(result.get(0).getName(), betType.getName());
    }
}
