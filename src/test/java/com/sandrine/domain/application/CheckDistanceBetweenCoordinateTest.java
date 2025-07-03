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

    @Test
    void should_return_false_when_coordinates_are_less_than_10km_apart() {
        CheckDistanceBetweenCoordinate checkDistanceBetweenCoordinate = new CheckDistanceBetweenCoordinate();

        Coordinate coordinate1 = new Coordinate(1L, 48.8584, 2.2945);
        Coordinate coordinate2 = new Coordinate(2L, 48.8408, 2.3200);

        Boolean result = checkDistanceBetweenCoordinate.isMoreThan(coordinate1, coordinate2, 10.0);

        assertEquals(false, result);
    }
}