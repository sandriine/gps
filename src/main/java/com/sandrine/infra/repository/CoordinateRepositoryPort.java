package com.sandrine.infra.repository;

import com.sandrine.domain.model.Coordinate;
import com.sandrine.domain.repository.CoordinateRepository;
import com.sandrine.infra.entity.CoordinateEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CoordinateRepositoryPort implements CoordinateRepository {

    private final JpaCoordinateRepository coordinateJpaRepository;

    public CoordinateRepositoryPort(JpaCoordinateRepository coordinateJpaRepository) {
        this.coordinateJpaRepository = coordinateJpaRepository;
    }

    @Override
    public Coordinate save(Coordinate coordinate) {
        CoordinateEntity entity = new CoordinateEntity(coordinate.id(), coordinate.latitude(), coordinate.longitude());
        CoordinateEntity saved = coordinateJpaRepository.save(entity);
        return new Coordinate(saved.getId(), saved.getLatitude(), saved.getLongitude());
    }

    @Override
    public List<Coordinate> findAll() {
        return coordinateJpaRepository.findAll()
                .stream().map(coordinateEntity ->
                        new Coordinate(coordinateEntity.getId(), coordinateEntity.getLatitude(), coordinateEntity.getLongitude())
                ).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        coordinateJpaRepository.deleteById(id);
    }
}