package com.sandrine.domain.model;

public record Coordinate(
        Long id,
        Double latitude,
        Double longitude
) {
    public Double getLatitudeDistance(Double latitude) {
        return Math.toRadians(latitude - this.latitude);
    }

    public Double getLongitudeDistance(Double longitude) {
        return Math.toRadians(longitude - this.longitude);
    }
}
