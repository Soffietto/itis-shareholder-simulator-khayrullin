package ru.kpfu.itis.shareholdersimulator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kpfu.itis.shareholdersimulator.controller.constants.Urls;
import ru.kpfu.itis.shareholdersimulator.controller.constants.Views;
import ru.kpfu.itis.shareholdersimulator.dto.BalanceDto;
import ru.kpfu.itis.shareholdersimulator.security.AuthDataHolder;
import ru.kpfu.itis.shareholdersimulator.service.BalanceService;

import static ru.kpfu.itis.shareholdersimulator.util.UrlUtil.redirect;

@Controller
@RequiredArgsConstructor
public class BalanceController {

    private final BalanceService balanceService;

    @GetMapping(Urls.Balance.BALANCE)
    public String getBalance(Model model) {
        model.addAttribute(AuthDataHolder.CURRENT_USER_BALANCE, balanceService.getCurrentUserBalanceAmount());
        model.addAttribute("balanceForm", new BalanceDto());
        return Views.BALANCE;
    }

    @PostMapping(Urls.Balance.BALANCE)
    public String postBalance(@ModelAttribute("balanceForm") BalanceDto balanceDto) {
        balanceService.saveNew(balanceDto);
        return redirect(Urls.Balance.BALANCE);
    }

}
