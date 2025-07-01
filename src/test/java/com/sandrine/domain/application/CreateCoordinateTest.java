package com.sandrine.domain.application;

import com.sandrine.domain.model.Coordinate;
import com.sandrine.domain.repository.CoordinateRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreateCoordinateTest {
    private CoordinateRepository coordinateRepository;

    @Test
    void should_create_coordinate() {
        CreateCoordinate useCase = new CreateCoordinate(coordinateRepository);

        Coordinate result = useCase.execute(48.8566, 2.3522);

        assertEquals(48.8566, result.latitude());
        assertEquals(2.3522, result.longitude());
    }
}