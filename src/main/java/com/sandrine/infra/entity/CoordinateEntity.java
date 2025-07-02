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

    public CoordinateEntity(Long id, double latitude, double longitude) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
