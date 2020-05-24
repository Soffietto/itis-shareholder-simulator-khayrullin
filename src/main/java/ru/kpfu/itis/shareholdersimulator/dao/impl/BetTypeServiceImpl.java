package ru.kpfu.itis.shareholdersimulator.dao.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.shareholdersimulator.dao.BetTypeDaoService;
import ru.kpfu.itis.shareholdersimulator.dto.BetTypeViewDto;
import ru.kpfu.itis.shareholdersimulator.mapper.BetTypeEntityMapper;
import ru.kpfu.itis.shareholdersimulator.service.BetTypeService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BetTypeServiceImpl implements BetTypeService {

    private final BetTypeDaoService betTypeDaoService;
    private final BetTypeEntityMapper betTypeEntityMapper;

    @Override
    public List<BetTypeViewDto> findAll() {
        return betTypeEntityMapper.toDto(betTypeDaoService.findAll());
    }
}
