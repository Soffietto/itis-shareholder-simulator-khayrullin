package ru.kpfu.itis.shareholdersimulator.dao;

import ru.kpfu.itis.shareholdersimulator.entity.User;

public interface UserDaoService {

    User findByLogin(String login);

    User save(User user);

    boolean existByLogin(String login);
}
