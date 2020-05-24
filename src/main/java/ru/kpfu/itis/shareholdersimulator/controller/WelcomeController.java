package ru.kpfu.itis.shareholdersimulator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kpfu.itis.shareholdersimulator.controller.constants.Urls;
import ru.kpfu.itis.shareholdersimulator.controller.constants.Views;
import ru.kpfu.itis.shareholdersimulator.security.AuthDataHolder;
import ru.kpfu.itis.shareholdersimulator.service.BalanceService;
import ru.kpfu.itis.shareholdersimulator.service.GameService;

@Controller
@RequiredArgsConstructor
public class WelcomeController {

    private final AuthDataHolder authDataHolder;
    private final BalanceService balanceService;
    private final GameService gameService;

    @GetMapping(Urls.MAIN)
    public String getMain(Model model) {
        model.addAttribute(AuthDataHolder.CURRENT_USER_NAME, authDataHolder.getUserName());
        model.addAttribute(AuthDataHolder.CURRENT_USER_BALANCE, balanceService.getCurrentUserBalanceAmount());
        model.addAttribute("bets", gameService.getCurrentUserBets());
        return Views.WELCOME;
    }
}
