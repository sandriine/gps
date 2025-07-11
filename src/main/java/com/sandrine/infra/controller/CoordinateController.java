package com.sandrine.infra.controller;

import com.sandrine.domain.application.CheckDistanceBetweenCoordinate;
import com.sandrine.domain.model.Coordinate;
import com.sandrine.domain.repository.CoordinateRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/coordinates")
public class CoordinateController {

    private final CoordinateRepository coordinateRepository;
    private final CheckDistanceBetweenCoordinate checkDistanceBetweenCoordinate;

    public CoordinateController(
            CoordinateRepository coordinateRepository,
            CheckDistanceBetweenCoordinate checkDistanceBetweenCoordinate
    ) {
        this.coordinateRepository = coordinateRepository;
        this.checkDistanceBetweenCoordinate = checkDistanceBetweenCoordinate;
    }

    @PostMapping("/create")
    public CoordinateResponse create(@RequestBody CoordinateRequest request) {
        Coordinate coordinate = coordinateRepository.save(new Coordinate(0L, request.latitude(), request.longitude()));
        return CoordinateResponse.from(coordinate);
    }

    @PostMapping("/check-distance")
    public boolean check(@RequestBody CheckDistanceRequest request) {
        return  checkDistanceBetweenCoordinate.isMoreThan(request.coordinate1(), request.coordinate2(), request.distanceToCheck());
    }

    @GetMapping
    public List<CoordinateResponse> getAll() {
        return this.coordinateRepository.findAll().stream().map(CoordinateResponse::from).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.coordinateRepository.delete(id);
    }
}