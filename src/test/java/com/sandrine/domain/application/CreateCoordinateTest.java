package com.sandrine.domain.application;

import com.sandrine.domain.model.Coordinate;
import com.sandrine.domain.repository.CoordinateRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreateCoordinateTest {
    @Test
    void should_create_coordinate() {
        CoordinateRepository repo = coordinate -> coordinate;
        CreateCoordinate useCase = new CreateCoordinate(repo);

        Coordinate result = useCase.execute(48.8566, 2.3522);

        assertEquals(48.8566, result.latitude());
        assertEquals(2.3522, result.longitude());
    }
}