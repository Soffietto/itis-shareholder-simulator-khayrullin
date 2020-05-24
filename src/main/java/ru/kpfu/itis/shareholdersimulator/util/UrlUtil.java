package ru.kpfu.itis.shareholdersimulator.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class UrlUtil {
    private static final String REDIRECT = "redirect:";

    public String redirect(String url) {
        return REDIRECT + url;
    }
}
