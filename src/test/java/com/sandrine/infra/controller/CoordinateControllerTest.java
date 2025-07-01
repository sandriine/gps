package com.sandrine.infra.controller;

import com.sandrine.domain.application.CreateCoordinate;
import com.sandrine.domain.model.Coordinate;
import com.sandrine.domain.repository.CoordinateRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@WebMvcTest(CoordinateController.class)
class CoordinateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CreateCoordinate createCoordinate;

    @MockBean
    private CoordinateRepository coordinateRepository;

    @Test
    void should_return_created_coordinate() throws Exception {
        when(createCoordinate.execute(12.0, 34.0))
                .thenReturn(new Coordinate(12.0, 34.0));

        mockMvc.perform(post("/coordinates/create")
                        .contentType(APPLICATION_JSON)
                        .content("{\"latitude\":12.0,\"longitude\":34.0}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.latitude").value(12.0))
                .andExpect(jsonPath("$.longitude").value(34.0));
    }

    @Test
    void should_return_all_coordinates() throws Exception {
        List<Coordinate> coordinates = List.of(
                new Coordinate(12.0, 34.0),
                new Coordinate(56.7, 89.1)
        );
        when(coordinateRepository.findAll()).thenReturn(coordinates);

        mockMvc.perform(get("/coordinates"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].latitude").value(12.0))
                .andExpect(jsonPath("$[0].longitude").value(34.0))
                .andExpect(jsonPath("$[1].latitude").value(56.7))
                .andExpect(jsonPath("$[1].longitude").value(89.1));
    }
}