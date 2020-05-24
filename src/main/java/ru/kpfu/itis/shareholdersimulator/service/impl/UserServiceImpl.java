package ru.kpfu.itis.shareholdersimulator.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.shareholdersimulator.dao.BalanceDaoService;
import ru.kpfu.itis.shareholdersimulator.dao.UserDaoService;
import ru.kpfu.itis.shareholdersimulator.dto.RegisterDto;
import ru.kpfu.itis.shareholdersimulator.entity.Balance;
import ru.kpfu.itis.shareholdersimulator.entity.User;
import ru.kpfu.itis.shareholdersimulator.entity.enums.Role;
import ru.kpfu.itis.shareholdersimulator.mapper.UserEntityMapper;
import ru.kpfu.itis.shareholdersimulator.security.impl.AuthDataHolderInSession;
import ru.kpfu.itis.shareholdersimulator.service.UserService;

import java.time.LocalDateTime;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final AuthDataHolderInSession authDataHolder;

    private final UserDaoService userDaoService;

    private final BalanceDaoService balanceDaoService;

    private final UserEntityMapper userEntityMapper;

    @Override
    public void register(RegisterDto registerDto) {
        if (!userDaoService.existByLogin(registerDto.getLogin())) {
            User user = userEntityMapper.toEntity(registerDto)
                    .setRoles(Collections.singletonList(Role.USER));
            User savedUser = userDaoService.save(user);
            Balance balance = createNewBalance(savedUser);
            balanceDaoService.save(balance);
        }
    }

    @Override
    public User getAuthenticatedUser() {
        return authDataHolder.getUser();
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userDaoService.findByLogin(username);
        String[] roles = user.getRoles().stream().map(Enum::toString).toArray(String[]::new);
        return org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password(String.valueOf(user.getPassword()))
                .roles(roles).build();
    }

    private Balance createNewBalance(User user) {
        return Balance.builder()
                .amount(0d)
                .dateTime(LocalDateTime.now())
                .user(user)
                .build();
    }
}
