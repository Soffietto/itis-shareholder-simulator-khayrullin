package ru.kpfu.itis.shareholdersimulator.controller;

import org.junit.Test;
import ru.kpfu.itis.shareholdersimulator.controller.constants.Urls;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class WelcomeControllerTest extends AbstractControllerTest {

    @Test
    public void getMainTest() throws Exception {
        mockMvc.perform(
                get(Urls.MAIN))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
