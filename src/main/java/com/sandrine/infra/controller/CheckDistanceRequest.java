package com.sandrine.infra.controller;

import com.sandrine.domain.model.Coordinate;

public record CheckDistanceRequest(
        double distanceToCheck,
        Coordinate coordinate1,
        Coordinate coordinate2
) {
}
