package ru.kpfu.itis.shareholdersimulator.security;

import ru.kpfu.itis.shareholdersimulator.entity.User;

public interface AuthDataHolder {

    String CURRENT_USER_NAME = "currentUserName";
    String CURRENT_USER_BALANCE = "currentUserBalance";

    String getUserName();

    User getUser();

    void setUser(User user);

}
