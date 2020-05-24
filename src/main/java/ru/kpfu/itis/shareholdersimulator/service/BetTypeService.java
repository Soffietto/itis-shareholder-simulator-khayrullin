package ru.kpfu.itis.shareholdersimulator.service;

import ru.kpfu.itis.shareholdersimulator.dto.BetTypeViewDto;

import java.util.List;

public interface BetTypeService {

    List<BetTypeViewDto> findAll();
}
