package com.sandrine.domain.application;

import com.sandrine.domain.model.Coordinate;
import com.sandrine.domain.repository.CoordinateRepository;

public class CreateCoordinate {
    private final CoordinateRepository repository;

    public CreateCoordinate(CoordinateRepository repository) {
        this.repository = repository;
    }

    public Coordinate execute(double latitude, double longitude) {
        Coordinate coordinate = new Coordinate(latitude, longitude);
        return repository.save(coordinate);
    }
}
