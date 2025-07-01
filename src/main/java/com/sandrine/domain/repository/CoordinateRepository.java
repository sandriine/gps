package com.sandrine.domain.repository;

import com.sandrine.domain.model.Coordinate;

import java.util.List;

public interface CoordinateRepository {
    Coordinate save(Coordinate coordinate);
    List<Coordinate> findAll();
}