package com.sandrine.domain.application;

import com.sandrine.domain.model.Coordinate;

public class CheckDistanceBetweenCoordinate {
    private static final double EARTH_RADIUS_KM = 6371.0;

    public boolean isMoreThan(Coordinate coordinate1, Coordinate coordinate2, Double checkDistance) {
        double distance = calculateDistance(coordinate1, coordinate2);
        return distance > checkDistance;
    }

    private double calculateDistance(Coordinate coordinate1, Coordinate coordinate2) {
        double latitudeDistance = coordinate1.getLatitudeDistance(coordinate2.latitude());
        double longitudeDistance = coordinate1.getLongitudeDistance(coordinate2.longitude());

        double haversineLat = Math.sin(latitudeDistance / 2) * Math.sin(latitudeDistance / 2);
        double haversineLng = Math.sin(longitudeDistance / 2) * Math.sin(longitudeDistance / 2);

        double haversineFormula = haversineLat +
                Math.cos(Math.toRadians(coordinate1.latitude())) * Math.cos(Math.toRadians(coordinate2.latitude())) * haversineLng;

        double centralAngle = 2 * Math.atan2(Math.sqrt(haversineFormula), Math.sqrt(1 - haversineFormula));
        return EARTH_RADIUS_KM * centralAngle;
    }
}
