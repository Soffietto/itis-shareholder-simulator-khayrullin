package ru.kpfu.itis.shareholdersimulator.security.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.shareholdersimulator.controller.constants.Urls;
import ru.kpfu.itis.shareholdersimulator.entity.Balance;
import ru.kpfu.itis.shareholdersimulator.security.AuthDataHolder;
import ru.kpfu.itis.shareholdersimulator.service.BalanceService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class AuthenticationSuccessHandlerImpl extends SimpleUrlAuthenticationSuccessHandler {

    private final AuthDataHolder authDataHolder;
    private final BalanceService balanceService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Balance balance = balanceService.findByUserLogin(userDetails.getUsername());
        authDataHolder.setUser(balance.getUser());
        response.sendRedirect(Urls.MAIN);
    }
}