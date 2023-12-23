package com.example.carservice.controllers;

import com.example.carservice.models.CarResponse;
import com.example.carservice.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarService service;

    @GetMapping
    public List<CarResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public CarResponse get() {
        return new CarResponse();
    }
}
