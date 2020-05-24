package ru.kpfu.itis.shareholdersimulator.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDto {
    private String name;
    private String login;
    private String password;
}
