package com.participant.registry;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@Slf4j
@SpringBootTest
@ActiveProfiles("integration")
@ContextConfiguration(initializers = {TestContainerInitializer.class})
public abstract class BaseIntegrationTest {
    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
    }
}
