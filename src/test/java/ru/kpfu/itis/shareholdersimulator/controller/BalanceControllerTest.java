package ru.kpfu.itis.shareholdersimulator.controller;

import org.junit.Test;
import ru.kpfu.itis.shareholdersimulator.controller.constants.Urls;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class BalanceControllerTest extends AbstractControllerTest {

    @Test
    public void getBalanceTest() throws Exception {
        mockMvc.perform(
                get(Urls.Balance.BALANCE))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
