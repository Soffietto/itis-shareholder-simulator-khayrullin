package ru.kpfu.itis.shareholdersimulator.controller.constants;

public interface Urls {

    String MAIN = "/main";
    String TINKOFF_STOCK_VALUE = "https://api-invest.tinkoff.ru/openapi/portfolio";

    interface User {
        String LOGIN = "/login";
        String REGISTER = "/register";
        String LOGOUT = "/logout";
    }

    interface Balance {
        String BALANCE = MAIN + "/balance";
    }

    interface Game {
        String GAME = MAIN + "/game";
    }
}
