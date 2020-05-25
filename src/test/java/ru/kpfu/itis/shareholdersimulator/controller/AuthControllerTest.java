package ru.kpfu.itis.shareholdersimulator.controller;

import org.junit.Test;
import ru.kpfu.itis.shareholdersimulator.controller.constants.Urls;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AuthControllerTest extends AbstractControllerTest {

    @Test
    public void loginTest() throws Exception {
        mockMvc.perform(
                get(Urls.User.LOGIN))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void registerTest() throws Exception {
        mockMvc.perform(
                get(Urls.User.REGISTER))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
