package com.participant.registry.api;

import com.participant.registry.BaseIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ParticipantControllerTest extends BaseIntegrationTest {

    @Test
    void should_be_able_to_access_participant_api() throws Exception {
        // Given
        MockHttpServletRequestBuilder requestBuilder = get("/hello")
            .contentType(APPLICATION_JSON);

        // When
        MvcResult result = mockMvc.perform(requestBuilder)
            .andExpect(status().isOk())
            .andReturn();

        // Then
        assertEquals("Hello World!", result.getResponse().getContentAsString());
    }
}
