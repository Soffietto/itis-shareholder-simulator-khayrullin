package ru.kpfu.itis.shareholdersimulator.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import ru.kpfu.itis.shareholdersimulator.controller.constants.Urls;
import ru.kpfu.itis.shareholdersimulator.entity.enums.Role;
import ru.kpfu.itis.shareholdersimulator.service.UserService;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;
    private final AuthenticationSuccessHandler authenticationSuccessHandler;

    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security.authorizeRequests()
                .antMatchers(Urls.User.LOGIN, Urls.User.REGISTER).anonymous()
                .antMatchers(Urls.MAIN + "*", Urls.MAIN + "/**").hasRole(Role.USER.toString());

        security.formLogin()
                .loginPage("/login")
                .usernameParameter("login")
                .defaultSuccessUrl(Urls.MAIN, true)
                .failureUrl("/login?error=true")
                .successHandler(authenticationSuccessHandler)
                .and()
                .logout().logoutSuccessUrl(Urls.User.LOGIN).deleteCookies("JSESSIONID")
                .and()
                .rememberMe().key("uniqueAndSecret").rememberMeParameter("remember-me-new")
                .and()
                .exceptionHandling();
    }

    @Override
    protected UserDetailsService userDetailsService() {
        return userService;
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new Argon2PasswordEncoder();
    }
}