package com.sandrine.infra.controller;

import com.sandrine.domain.model.Coordinate;

public record CoordinateResponse(double latitude, double longitude) {
    public static CoordinateResponse from(Coordinate coordinate) {
        return new CoordinateResponse(coordinate.latitude(), coordinate.longitude());
    }
}
