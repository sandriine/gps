package com.sandrine.infra.repository;

import com.sandrine.domain.model.Coordinate;
import com.sandrine.infra.entity.CoordinateEntity;
import org.springframework.stereotype.Repository;

@Repository
public class CoordinateRepositoryPort implements com.sandrine.domain.repository.CoordinateRepository {

    private final JpaCoordinateRepository coordinateJpaRepository;

    public CoordinateRepositoryPort(JpaCoordinateRepository coordinateJpaRepository) {
        this.coordinateJpaRepository = coordinateJpaRepository;
    }

    @Override
    public Coordinate save(Coordinate coordinate) {
        CoordinateEntity entity = new CoordinateEntity(coordinate.latitude(), coordinate.longitude());
        CoordinateEntity saved = coordinateJpaRepository.save(entity);
        return new Coordinate(saved.getLatitude(), saved.getLongitude());
    }
}