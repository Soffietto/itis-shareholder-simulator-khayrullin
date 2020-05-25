package ru.kpfu.itis.shareholdersimulator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import ru.kpfu.itis.shareholdersimulator.ShareholderSimulatorApplicationTests;

public abstract class AbstractControllerTest extends ShareholderSimulatorApplicationTests {

    @Autowired
    protected MockMvc mockMvc;

}
