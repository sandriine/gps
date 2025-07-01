package com.sandrine.domain.application;

import com.sandrine.domain.model.Coordinate;

public class CheckDistanceBetweenCoordinate {
    private static final double EARTH_RADIUS_KM = 6371.0;

    public boolean isMoreThan(Coordinate coordinate1, Coordinate coordinate2, Double checkDistance) {
        double distance = haversine(coordinate1.latitude(), coordinate1.longitude(), coordinate2.latitude(), coordinate2.longitude());
        return distance > checkDistance;
    }

    private double haversine(double lat1, double lon1, double lat2, double lon2) {
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double rLat1 = Math.toRadians(lat1);
        double rLat2 = Math.toRadians(lat2);

        double a = Math.pow(Math.sin(dLat / 2), 2)
                + Math.cos(rLat1) * Math.cos(rLat2)
                * Math.pow(Math.sin(dLon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return EARTH_RADIUS_KM * c;
    }
}
