package ru.kpfu.itis.shareholdersimulator.dao.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.shareholdersimulator.dao.UserDaoService;
import ru.kpfu.itis.shareholdersimulator.entity.User;
import ru.kpfu.itis.shareholdersimulator.exception.NotFoundInDbException;
import ru.kpfu.itis.shareholdersimulator.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserDaoServiceImpl implements UserDaoService {

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public User findByLogin(String login) {
        return userRepository.findByLogin(login)
                .orElseThrow(NotFoundInDbException::new);
    }

    @Override
    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existByLogin(String login) {
        return userRepository.existsByLogin(login);
    }
}
