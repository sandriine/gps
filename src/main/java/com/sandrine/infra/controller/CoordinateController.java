package com.sandrine.infra.controller;

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

    public CoordinateController(CreateCoordinate createCoordinate, CoordinateRepository coordinateRepository) {
        this.createCoordinate = createCoordinate;
        this.coordinateRepository = coordinateRepository;
    }

    @PostMapping("/create")
    public CoordinateResponse create(@RequestBody CoordinateRequest request) {
        Coordinate coordinate = createCoordinate.execute(request.latitude(), request.longitude());
        return CoordinateResponse.from(coordinate);
    }

    @GetMapping
    public List<CoordinateResponse> getAll() {
        return this.coordinateRepository.findAll().stream().map(CoordinateResponse::from).collect(Collectors.toList());
    }
}