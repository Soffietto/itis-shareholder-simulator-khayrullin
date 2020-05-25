package ru.kpfu.itis.shareholdersimulator.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.BeforeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import ru.kpfu.itis.shareholdersimulator.ShareholderSimulatorApplicationTests;

public class AbstractControllerTest extends ShareholderSimulatorApplicationTests {

    @Autowired
    protected MockMvc mockMvc;

}
