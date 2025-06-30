package com.sandrine.domain.repository;

import com.sandrine.domain.model.Coordinate;

public interface CoordinateRepository {
    Coordinate save(Coordinate coordinate);
}