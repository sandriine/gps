package com.sandrine.infra.controller;

import com.sandrine.domain.application.CheckDistanceBetweenCoordinate;
import com.sandrine.domain.application.CreateCoordinate;
import com.sandrine.domain.model.Coordinate;
import com.sandrine.domain.repository.CoordinateRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/coordinates")
public class CoordinateController {

    private final CreateCoordinate createCoordinate;
    private final CoordinateRepository coordinateRepository;
    private final CheckDistanceBetweenCoordinate checkDistanceBetweenCoordinate;

    public CoordinateController(
            CreateCoordinate createCoordinate,
            CoordinateRepository coordinateRepository,
            CheckDistanceBetweenCoordinate checkDistanceBetweenCoordinate
    ) {
        this.createCoordinate = createCoordinate;
        this.coordinateRepository = coordinateRepository;
        this.checkDistanceBetweenCoordinate = checkDistanceBetweenCoordinate;
    }

    @PostMapping("/create")
    public CoordinateResponse create(@RequestBody CoordinateRequest request) {
        Coordinate coordinate = createCoordinate.execute(request.latitude(), request.longitude());
        return CoordinateResponse.from(coordinate);
    }

    @PostMapping("/check-distance")
    public CheckDistanceResponse check(@RequestBody CheckDistanceRequest request) {
        boolean result = checkDistanceBetweenCoordinate.isMoreThan(request.coordinate1(), request.coordinate2(), request.distanceToCheck());
        return new CheckDistanceResponse(result);
    }

    @GetMapping
    public List<CoordinateResponse> getAll() {
        return this.coordinateRepository.findAll().stream().map(CoordinateResponse::from).collect(Collectors.toList());
    }
}