package com.sandrine.infra.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "coordinates")
public class CoordinateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double latitude;
    private double longitude;

    protected CoordinateEntity() {} // JPA only

    public CoordinateEntity(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
