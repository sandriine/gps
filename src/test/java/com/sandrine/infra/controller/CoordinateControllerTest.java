package com.sandrine.infra.controller;

import com.sandrine.domain.application.CreateCoordinate;
import com.sandrine.domain.model.Coordinate;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@SpringBootTest
@AutoConfigureMockMvc
class CoordinateControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    CreateCoordinate createCoordinate;

    @Test
    void should_return_created_coordinate() throws Exception {
        when(createCoordinate.execute(12.0, 34.0))
                .thenReturn(new Coordinate(12.0, 34.0));

        mockMvc.perform(post("/coordinates")
                        .contentType(APPLICATION_JSON)
                        .content("{\"latitude\":12.0,\"longitude\":34.0}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.latitude").value(12.0))
                .andExpect(jsonPath("$.longitude").value(34.0));
    }

}