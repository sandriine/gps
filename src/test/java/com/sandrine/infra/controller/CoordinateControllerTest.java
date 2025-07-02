package com.sandrine.infra.controller;

import com.sandrine.domain.application.CheckDistanceBetweenCoordinate;
import com.sandrine.domain.model.Coordinate;
import com.sandrine.domain.repository.CoordinateRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@WebMvcTest(CoordinateController.class)
class CoordinateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CoordinateRepository coordinateRepository;

    @MockBean
    private CheckDistanceBetweenCoordinate checkDistanceBetweenCoordinate;

    @Test
    void should_return_created_coordinate() throws Exception {
        Coordinate coordinate = new Coordinate(1L, 12.0, 34.0);
        when(coordinateRepository.save(coordinate)).thenReturn(coordinate);

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
                new Coordinate(1L, 12.0, 34.0),
                new Coordinate(2L, 56.7, 89.1)
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

    @Test
    void should_delete_coordinate() throws Exception {
        mockMvc.perform(delete("/coordinates/1"))
                .andExpect(status().isOk());
    }

    @Test
    void should_return_true_if_distance_is_more_than_10km() throws Exception {

        when(checkDistanceBetweenCoordinate.isMoreThan(
                new Coordinate(1L, 48.8566, 2.3522),
                new Coordinate(2L, 49.8566, 2.3522),
                10.0
        )).thenReturn(true);

        mockMvc.perform(post("/coordinates/check-distance")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "distanceToCheck": 10.0,
                                    "coordinate1": {
                                       "latitude": 48.8566,
                                       "longitude": 2.3522                \s
                                    },
                                    "coordinate2": {
                                       "latitude": 49.8566,
                                       "longitude": 2.3522                         \s
                                    }                                                                                              \s
                                }
                               \s"""))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.moreThanDistance").value(true));
    }
}