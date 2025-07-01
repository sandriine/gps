package com.sandrine.infra.repository;

import com.sandrine.domain.model.Coordinate;
import com.sandrine.infra.entity.CoordinateEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<Coordinate> findAll() {
        return coordinateJpaRepository.findAll()
                .stream().map(coordinateEntity ->
                        new Coordinate(coordinateEntity.getLatitude(), coordinateEntity.getLongitude())
                ).collect(Collectors.toList());
    }
}