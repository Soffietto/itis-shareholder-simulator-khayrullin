package ru.kpfu.itis.shareholdersimulator.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kpfu.itis.shareholdersimulator.dto.RegisterDto;
import ru.kpfu.itis.shareholdersimulator.entity.User;

public interface UserService extends UserDetailsService {

    void register(RegisterDto registerDto);

    User getAuthenticatedUser();
}
