package ru.kpfu.itis.shareholdersimulator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.kpfu.itis.shareholdersimulator.controller.constants.Urls;
import ru.kpfu.itis.shareholdersimulator.controller.constants.Views;
import ru.kpfu.itis.shareholdersimulator.dto.BetFormDto;
import ru.kpfu.itis.shareholdersimulator.security.AuthDataHolder;
import ru.kpfu.itis.shareholdersimulator.service.BalanceService;
import ru.kpfu.itis.shareholdersimulator.service.BetTypeService;
import ru.kpfu.itis.shareholdersimulator.service.GameService;
import ru.kpfu.itis.shareholdersimulator.service.StocksService;

import static ru.kpfu.itis.shareholdersimulator.util.UrlUtil.redirect;

@Controller
@RequiredArgsConstructor
public class GameController {

    private final BetTypeService betTypeService;
    private final GameService gameService;
    private final BalanceService balanceService;
    private final StocksService stocksService;

    @GetMapping(Urls.Game.GAME)
    public String getGame(Model model) {
        model.addAttribute("isInGame", gameService.isAlreadyInGame());
        model.addAttribute(AuthDataHolder.CURRENT_USER_BALANCE, balanceService.getCurrentUserBalanceAmount());
        model.addAttribute("currentStockValue", stocksService.getCurrentStockValue());
        model.addAttribute("betForm", new BetFormDto());
        model.addAttribute("betTypes", betTypeService.findAll());
        return Views.GAME;
    }

    @PostMapping(Urls.Game.GAME)
    public String postGame(@ModelAttribute("betForm") BetFormDto betFormDto,
                           RedirectAttributes redir) {
        try {
            gameService.makeBet(betFormDto.getAmount(), betFormDto.getBetTypeId());
        } catch (RuntimeException ex) {
            redir.addFlashAttribute("error", ex.getMessage());
            return redirect(Urls.Game.GAME);
        }
        return redirect(Urls.MAIN);
    }
}
