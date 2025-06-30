package com.sandrine.infra.repository;

import com.sandrine.domain.model.Coordinate;
import com.sandrine.infra.document.CoordinateDocument;
import org.springframework.stereotype.Repository;

@Repository
public class CoordinateRepositoryPort implements com.sandrine.domain.repository.CoordinateRepository {

    private final CoordinateRepository springDataRepository;

    public CoordinateRepositoryPort(CoordinateRepository springDataRepository) {
        this.springDataRepository = springDataRepository;
    }

    @Override
    public Coordinate save(Coordinate coordinate) {
        CoordinateDocument doc = new CoordinateDocument(coordinate.getLatitude(), coordinate.getLongitude());
        CoordinateDocument saved = springDataRepository.save(doc);
        return new Coordinate(saved.getLatitude(), saved.getLongitude());
    }
}