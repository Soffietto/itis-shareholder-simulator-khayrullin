package ru.kpfu.itis.shareholdersimulator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.shareholdersimulator.controller.constants.Urls;
import ru.kpfu.itis.shareholdersimulator.controller.constants.Views;
import ru.kpfu.itis.shareholdersimulator.dto.LoginDto;
import ru.kpfu.itis.shareholdersimulator.dto.RegisterDto;
import ru.kpfu.itis.shareholdersimulator.service.UserService;

import static ru.kpfu.itis.shareholdersimulator.util.UrlUtil.redirect;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @GetMapping(Urls.User.LOGIN)
    public String login(@RequestParam(value = "error", required = false) boolean error, Model model) {
        model.addAttribute("error", error);
        model.addAttribute("loginForm", new LoginDto());
        return Views.LOGIN;
    }

    @GetMapping(Urls.User.REGISTER)
    public String register(Model model) {
        model.addAttribute("user", new RegisterDto());
        return Views.REGISTER;
    }

    @PostMapping(Urls.User.REGISTER)
    public String register(@ModelAttribute("user") RegisterDto registerDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return Views.REGISTER;
        }
        userService.register(registerDto);
        return redirect(Urls.MAIN);
    }
}
