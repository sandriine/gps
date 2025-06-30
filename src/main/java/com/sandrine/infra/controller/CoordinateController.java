package com.sandrine.infra.controller;

import com.sandrine.domain.application.CreateCoordinate;
import com.sandrine.domain.model.Coordinate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coordinates")
public class CoordinateController {

    private final CreateCoordinate createCoordinate;

    public CoordinateController(CreateCoordinate createCoordinate) {
        this.createCoordinate = createCoordinate;
    }

    @PostMapping
    public CoordinateResponse create(@RequestBody CoordinateRequest request) {
        Coordinate coordinate = createCoordinate.execute(request.latitude(), request.longitude());
        return new CoordinateResponse(coordinate.getLatitude(), coordinate.getLongitude());
    }

    public record CoordinateRequest(double latitude, double longitude) {}
    public record CoordinateResponse(double latitude, double longitude) {}
}