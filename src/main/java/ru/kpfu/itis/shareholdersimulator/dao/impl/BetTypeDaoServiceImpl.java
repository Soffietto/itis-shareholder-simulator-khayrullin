package ru.kpfu.itis.shareholdersimulator.dao.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.shareholdersimulator.dao.BetTypeDaoService;
import ru.kpfu.itis.shareholdersimulator.entity.BetType;
import ru.kpfu.itis.shareholdersimulator.exception.NotFoundInDbException;
import ru.kpfu.itis.shareholdersimulator.repository.BetTypeRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BetTypeDaoServiceImpl implements BetTypeDaoService {

    private final BetTypeRepository betTypeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<BetType> findAll() {
        return betTypeRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public BetType findById(UUID id) {
        return betTypeRepository.findById(id)
                .orElseThrow(NotFoundInDbException::new);
    }
}
