package com.sandrine.infra.controller;

import com.sandrine.domain.model.Coordinate;

public record CoordinateResponse(Long id, double latitude, double longitude) {
    public static CoordinateResponse from(Coordinate coordinate) {
        return new CoordinateResponse(coordinate.id(), coordinate.latitude(), coordinate.longitude());
    }
}
