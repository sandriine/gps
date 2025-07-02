package com.sandrine.domain.application;

import com.sandrine.domain.model.Coordinate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckDistanceBetweenCoordinateTest {

    @Test
    void should_return_true_when_coordinates_are_more_than_10km_apart() {
        CheckDistanceBetweenCoordinate checkDistanceBetweenCoordinate = new CheckDistanceBetweenCoordinate();

        Coordinate coordinate1 = new Coordinate(175897099L, 65.764586, 76.7465475);
        Coordinate coordinate2 = new Coordinate(867869878L, 198.85769, 789.875678);

        Boolean result = checkDistanceBetweenCoordinate.isMoreThan(coordinate1, coordinate2, 10.0);

        assertEquals(true, result);
    }
}