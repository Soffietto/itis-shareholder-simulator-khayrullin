package ru.kpfu.itis.shareholdersimulator.controller.constants;

public interface Urls {

    String MAIN = "/main";

    interface User {
        String LOGIN = "/login";
        String REGISTER = "/register";
    }

    interface Balance {
        String BALANCE = MAIN + "/balance";
    }

    interface Game {
        String GAME = MAIN + "/game";
    }
}
