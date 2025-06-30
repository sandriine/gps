package com.sandrine.infra.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "coordinates")
public class CoordinateDocument {

    @Id
    private String id;
    private double latitude;
    private double longitude;

    public CoordinateDocument() {}

    public CoordinateDocument(double latitude, double longitude) {
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