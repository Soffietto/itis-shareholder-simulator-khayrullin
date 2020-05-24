package ru.kpfu.itis.shareholdersimulator.dao;

import ru.kpfu.itis.shareholdersimulator.entity.BetType;

import java.util.List;
import java.util.UUID;

public interface BetTypeDaoService {

    List<BetType> findAll();

    BetType findById(UUID id);
}
